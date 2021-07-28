package ru.fivkin;

import ru.fivkin.credit.dto.CreditInformation;
import ru.fivkin.credit.dto.OutInformationAboutCredit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculation {

    public static boolean checkDoubleZero(Double checkData) {
        return checkData <= 0;
    }

    public static boolean checkIntZero(Integer checkData) {
        return checkData <= 0;
    }

    public static int checkBigDecimalZero(BigDecimal checkData) {
        BigDecimal zero = new BigDecimal(0);
        return checkData.compareTo(zero);
    }

    public static List<OutInformationAboutCredit> getAnnuityCalculation(CreditInformation creditInformation) {
        List<OutInformationAboutCredit> listCalculation = new ArrayList<>();
        try {
            if (checkBigDecimalZero(creditInformation.getSumCredit()) > 0 && !checkDoubleZero(creditInformation.getInterestRate()) && !checkIntZero(creditInformation.getLoanPeriod())) {

                for (int i = 0; i < creditInformation.getLoanPeriod(); i++) {
                    OutInformationAboutCredit outInformationAboutCredit = new OutInformationAboutCredit();
                    double monthlyRate = creditInformation.getInterestRate() / (12 * 100);
                    outInformationAboutCredit.setMonthlyPayment(creditInformation.getSumCredit().toBigInteger().doubleValue() * (monthlyRate + ((monthlyRate) / (Math.pow(1 + monthlyRate, 12 - i) - 1))));
                    outInformationAboutCredit.setPercent(creditInformation.getSumCredit().toBigInteger().doubleValue() * monthlyRate);
                    outInformationAboutCredit.setRepaymentAmount(outInformationAboutCredit.getMonthlyPayment() - outInformationAboutCredit.getPercent());

                    creditInformation.setDateCredit(creditInformation.getDateCredit().plusMonths(1));
                    outInformationAboutCredit.setDatePayment(creditInformation.getDateCredit());

                    outInformationAboutCredit.setSumCredit(creditInformation.getSumCredit());

                    listCalculation.add(outInformationAboutCredit);

                    creditInformation.setSumCredit(creditInformation.getSumCredit().subtract(BigDecimal.valueOf(outInformationAboutCredit.getRepaymentAmount())));
                }

            }
            return listCalculation;
        } catch (NullPointerException e) {
            System.err.println("Exception NullPointer");
            return listCalculation;
        } catch (ArithmeticException e) {
            System.err.println("Exception ArithmeticException");
            return listCalculation;
        }
    }

    public static List<OutInformationAboutCredit> getDiffCalculation(CreditInformation creditInformation) {
        List<OutInformationAboutCredit> listCalculation = new ArrayList<>();


        try {
            if (checkBigDecimalZero(creditInformation.getSumCredit()) > 0 && !checkDoubleZero(creditInformation.getInterestRate()) && !checkIntZero(creditInformation.getLoanPeriod())) {

                double repayment = creditInformation.getSumCredit().toBigInteger().doubleValue() / creditInformation.getLoanPeriod();
                for (int i = 0; i < creditInformation.getLoanPeriod(); i++) {
                    OutInformationAboutCredit outInformationAboutCredit = new OutInformationAboutCredit();
                    outInformationAboutCredit.setRepaymentAmount(repayment);
                    double monthlyRate = creditInformation.getInterestRate() / (12 * 100);
                    outInformationAboutCredit.setPercent(creditInformation.getSumCredit().toBigInteger().doubleValue() * monthlyRate);
                    outInformationAboutCredit.setMonthlyPayment(outInformationAboutCredit.getRepaymentAmount() + outInformationAboutCredit.getPercent());


                    creditInformation.setDateCredit(creditInformation.getDateCredit().plusMonths(1));
                    outInformationAboutCredit.setDatePayment(creditInformation.getDateCredit());

                    outInformationAboutCredit.setSumCredit(creditInformation.getSumCredit());

                    listCalculation.add(outInformationAboutCredit);

                    creditInformation.setSumCredit(creditInformation.getSumCredit().subtract(BigDecimal.valueOf(outInformationAboutCredit.getRepaymentAmount())));
                }
            }

            return listCalculation;
        } catch (NullPointerException e) {
            System.err.println("Exception NullPointer");
            return listCalculation;
        } catch (ArithmeticException e) {
            System.err.println("Exception ArithmeticException");
            return listCalculation;
        }
    }
}
