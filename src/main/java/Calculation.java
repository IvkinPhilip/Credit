import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calculation {

    String listDayPayment;
    double listMonthlyRate;
    double listMonthlyPayment;
    double listPercent;
    double listRepaymentAmount;

    public Calculation(String listDayPayment, double listMonthlyRate, double listMonthlyPayment, double listPercent, double listRepaymentAmount) {
        this.listDayPayment = listDayPayment;
        this.listMonthlyRate = listMonthlyRate;
        this.listMonthlyPayment = listMonthlyPayment;
        this.listPercent = listPercent;
        this.listRepaymentAmount = listRepaymentAmount;
    }

    @Override
    public String toString() {
        return
                " DayPayment: " + listDayPayment +
                        " MonthlyRate: " + listMonthlyRate +
                        " MonthlyPayment: " + listMonthlyPayment +
                        " Percent: " + listPercent +
                        " RepaymentAmount: " + listRepaymentAmount;
    }

    public Calculation() {

    }

    public boolean checkDoubleZero(Double checkData) {
        return checkData <= 0;
    }

    public boolean checkIntZero(Integer checkData) {
        return checkData <= 0;
    }

    public List<Calculation> getAnnuityCalculation(double sumCredit, double interestRate, int loanPeriod, Calendar dateCredit) {
        List<Calculation> listCalculation = new ArrayList<>();
        try {
            if (!checkDoubleZero(sumCredit) && !checkDoubleZero(interestRate) && !checkIntZero(loanPeriod)) {

                for (int i = 0; i < loanPeriod; i++) {
                    double monthlyRate = interestRate / (12 * 100);
                    double monthlyPayment = sumCredit * (monthlyRate + (monthlyRate) / (Math.pow(1 + monthlyRate, 12 - i) - 1));
                    double percent = sumCredit * monthlyRate;
                    double repaymentAmount = monthlyPayment - percent;

                    dateCredit.add(Calendar.MONTH, 1);

                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    String formatted = formatDate.format(dateCredit.getTime());

                    listCalculation.add(new Calculation(formatted, monthlyPayment, repaymentAmount, percent, sumCredit));

                    sumCredit -= repaymentAmount;
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

    public List<Calculation> getDiffCalculation(double sumCredit, double interestRate, int loanPeriod, Calendar dateCredit) {
        ArrayList<Calculation> listCalculation = new ArrayList<>();
        double repaymentAmount = sumCredit / loanPeriod;

        for (int i = 0; i < loanPeriod; i++) {
            double monthlyRate = interestRate / (12 * 100);
            double percent = sumCredit * monthlyRate;
            double monthlyPayment = repaymentAmount + percent;

            dateCredit.add(Calendar.MONTH, 1);

            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = formatDate.format(dateCredit.getTime());

            listCalculation.add(new Calculation(formatted, monthlyPayment, repaymentAmount, percent, sumCredit));

            sumCredit -= repaymentAmount;
        }

        return listCalculation;
    }
}
