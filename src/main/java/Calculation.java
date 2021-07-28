import ru.fivkin.credit.dto.CreditInformation;
import ru.fivkin.credit.dto.OutInformationAboutCredit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calculation {

    public static boolean checkDoubleZero(Double checkData) {
        return checkData <= 0;
    }

    public static boolean checkIntZero(Integer checkData) {
        return checkData <= 0;
    }

    public static List<OutInformationAboutCredit> getAnnuityCalculation(CreditInformation creditInformation) {
        List<OutInformationAboutCredit> listCalculation = new ArrayList<>();
        OutInformationAboutCredit outInformationAboutCredit = new OutInformationAboutCredit();
        try {
            if (!checkDoubleZero(creditInformation.getSumCredit()) && !checkDoubleZero(creditInformation.getInterestRate()) && !checkIntZero(creditInformation.getLoanPeriod())) {

                for (int i = 0; i < creditInformation.getLoanPeriod(); i++) {
                    double monthlyRate = (double) creditInformation.getLoanPeriod() / (12 * 100);
                    outInformationAboutCredit.setMonthlyPayment(creditInformation.getSumCredit() * (monthlyRate + (monthlyRate) / (Math.pow(1 + monthlyRate, 12 - i) - 1)));
                    outInformationAboutCredit.setPercent(creditInformation.getSumCredit() * monthlyRate);
                    outInformationAboutCredit.setRepaymentAmount(outInformationAboutCredit.getMonthlyPayment() - outInformationAboutCredit.getPercent());

                    creditInformation.setDateCredit(creditInformation.getDateCredit().plusMonths(1));

                    listCalculation.add(outInformationAboutCredit);

                    creditInformation.setSumCredit(creditInformation.getSumCredit() - outInformationAboutCredit.getRepaymentAmount());
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
        OutInformationAboutCredit outInformationAboutCredit = new OutInformationAboutCredit();
        try {
            outInformationAboutCredit.setRepaymentAmount(creditInformation.getSumCredit() / creditInformation.getLoanPeriod());

            for (int i = 0; i < creditInformation.getLoanPeriod(); i++) {
                double monthlyRate = creditInformation.getInterestRate() / (12 * 100);
                outInformationAboutCredit.setPercent(creditInformation.getSumCredit() * monthlyRate);
                outInformationAboutCredit.setMonthlyPayment(outInformationAboutCredit.getRepaymentAmount() + outInformationAboutCredit.getPercent());

                creditInformation.setDateCredit(creditInformation.getDateCredit().plusMonths(1));

                listCalculation.add(outInformationAboutCredit);

                creditInformation.setSumCredit(creditInformation.getSumCredit() - outInformationAboutCredit.getRepaymentAmount());
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
