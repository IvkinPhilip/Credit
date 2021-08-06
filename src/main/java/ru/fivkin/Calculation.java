package ru.fivkin;

import lombok.extern.slf4j.Slf4j;
import ru.fivkin.credit.dto.CreditInformation;
import ru.fivkin.credit.dto.OutInformationAboutCredit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Calculation {

    private Calculation() {

    }

    public static boolean checkDoubleZero(Double checkData) {
        return checkData > 0;
    }

    public static boolean checkIntZero(Integer checkData) {
        return checkData > 0;
    }

    public static int checkBigDecimalZero(BigDecimal checkData) {
        BigDecimal zero = new BigDecimal(0);
        return checkData.compareTo(zero);
    }

    public static List<OutInformationAboutCredit> getAnnuityCalculation(CreditInformation creditInformation) {
        List<OutInformationAboutCredit> listCalculation = new ArrayList<>();
        try {
            if (checkBigDecimalZero(creditInformation.getSumCredit()) > 0 && checkDoubleZero(creditInformation.getInterestRate()) && checkIntZero(creditInformation.getLoanPeriod())) {
                for (int i = 0; i < creditInformation.getLoanPeriod(); i++) {
                    OutInformationAboutCredit outInformationAboutCredit = new OutInformationAboutCredit();
                    double monthlyRate = creditInformation.getInterestRate() / (12 * 100);
                    outInformationAboutCredit.setMonthlyPayment(creditInformation.getSumCredit().multiply(BigDecimal.valueOf(monthlyRate + ((monthlyRate) / (Math.pow(1 + monthlyRate, 12.0 - i) - 1)))).setScale(13, RoundingMode.HALF_DOWN));
                    outInformationAboutCredit.setPercent(creditInformation.getSumCredit().multiply(BigDecimal.valueOf(monthlyRate)).setScale(12, RoundingMode.HALF_DOWN));
                    outInformationAboutCredit.setRepaymentAmount(outInformationAboutCredit.getMonthlyPayment().subtract(outInformationAboutCredit.getPercent()).setScale(13, RoundingMode.HALF_DOWN));

                    creditInformation.setDateCredit(creditInformation.getDateCredit().plusMonths(1));
                    outInformationAboutCredit.setDatePayment(creditInformation.getDateCredit());

                    outInformationAboutCredit.setSumCredit(creditInformation.getSumCredit().setScale(13, RoundingMode.HALF_DOWN));

                    listCalculation.add(outInformationAboutCredit);

                    creditInformation.setSumCredit(creditInformation.getSumCredit().subtract(outInformationAboutCredit.getRepaymentAmount()).setScale(13, RoundingMode.HALF_DOWN));
                }

            }
            return listCalculation;
        } catch (NullPointerException | ArithmeticException e) {
            log.error(e.getMessage(), e);
            return listCalculation;
        }
    }

    public static List<OutInformationAboutCredit> getDiffCalculation(CreditInformation creditInformation) {
        List<OutInformationAboutCredit> listCalculation = new ArrayList<>();
        try {
            if (checkBigDecimalZero(creditInformation.getSumCredit()) > 0 && checkDoubleZero(creditInformation.getInterestRate()) && checkIntZero(creditInformation.getLoanPeriod())) {

                BigDecimal repayment = creditInformation.getSumCredit().divide(BigDecimal.valueOf(creditInformation.getLoanPeriod())) ;
                for (int i = 0; i < creditInformation.getLoanPeriod(); i++) {
                    OutInformationAboutCredit outInformationAboutCredit = new OutInformationAboutCredit();
                    outInformationAboutCredit.setRepaymentAmount(repayment);
                    double monthlyRate = creditInformation.getInterestRate() / (12 * 100);
                    outInformationAboutCredit.setPercent(creditInformation.getSumCredit().multiply(BigDecimal.valueOf(monthlyRate)).setScale(13, RoundingMode.HALF_DOWN));
                    outInformationAboutCredit.setMonthlyPayment(outInformationAboutCredit.getRepaymentAmount().add(outInformationAboutCredit.getPercent()).setScale(13, RoundingMode.HALF_DOWN));


                    creditInformation.setDateCredit(creditInformation.getDateCredit().plusMonths(1));
                    outInformationAboutCredit.setDatePayment(creditInformation.getDateCredit());

                    outInformationAboutCredit.setSumCredit(creditInformation.getSumCredit());

                    listCalculation.add(outInformationAboutCredit);

                    creditInformation.setSumCredit(creditInformation.getSumCredit().subtract(outInformationAboutCredit.getRepaymentAmount()).setScale(13, RoundingMode.HALF_DOWN));
                }
            }

            return listCalculation;
        } catch (NullPointerException | ArithmeticException e) {
            log.error(e.getMessage(), e);
            return listCalculation;
        }
    }
}
