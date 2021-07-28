package ru.fivkin;

import org.junit.jupiter.api.Test;
import ru.fivkin.credit.dto.CreditInformation;
import ru.fivkin.credit.dto.OutInformationAboutCredit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.fivkin.Calculation.getAnnuityCalculation;
import static ru.fivkin.Calculation.getDiffCalculation;

class CalculationTest {
    CreditInformation creditInformation = new CreditInformation();

    void testZeroAndNullAnnuityCalculation(BigDecimal var, Double interestRate, Integer loanPeriod, LocalDate date) {
        creditInformation.setSumCredit(var);
        creditInformation.setInterestRate(interestRate);
        creditInformation.setLoanPeriod(loanPeriod);
        creditInformation.setDateCredit(date);
        List<OutInformationAboutCredit> testList = getAnnuityCalculation(creditInformation);
        List<OutInformationAboutCredit> testResult = new ArrayList<>();
        assertEquals(testResult, testList);
    }

    void testZeroAndNullDiffCalculation(BigDecimal var, Double interestRate, Integer loanPeriod, LocalDate date) {
        creditInformation.setSumCredit(var);
        creditInformation.setInterestRate(interestRate);
        creditInformation.setLoanPeriod(loanPeriod);
        creditInformation.setDateCredit(date);
        List<OutInformationAboutCredit> testList = getDiffCalculation(creditInformation);
        List<OutInformationAboutCredit> testResult = new ArrayList<>();
        assertEquals(testResult, testList);
    }

    @Test
    void testZeroSumCreditAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(0), 17.5, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullSumCreditAnnuityAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(null, 17.5, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testZeroInterestRateAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(30000), 0.0, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullInterestRateAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(30000), null, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testZeroLoanPeriodAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(30000), 17.5, 0, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullLoanPeriodAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(30000), 17.5, null, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullDateCreditAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(30000), 17.5, 12, null);
    }

    @Test
    void testMinusSumCreditAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(-1), 17.5, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testMinusInterestRateAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(30000), -1.0, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testMinusLoanPeriodAnnuityCalculation() {
        testZeroAndNullAnnuityCalculation(BigDecimal.valueOf(30000), 17.5, -1, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testZeroSumCreditDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(0), 17.5, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullSumCreditDiffAnnuityCalculation() {
        testZeroAndNullDiffCalculation(null, 17.5, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testZeroInterestRateDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(30000), 0.0, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullInterestRateDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(30000), null, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testZeroLoanPeriodDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(30000), 17.5, 0, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullLoanPeriodDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(30000), 17.5, null, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testNullDateCreditDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(30000), 17.5, 12, null);
    }

    @Test
    void testMinusSumCreditDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(-1), 17.5, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testMinusInterestRateDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(30000), -1.0, 12, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    @Test
    void testMinusLoanPeriodDiffCalculation() {
        testZeroAndNullDiffCalculation(BigDecimal.valueOf(30000), 17.5, -1, LocalDate.of(2017, Month.NOVEMBER, 30));
    }

    List<OutInformationAboutCredit> initValuesAnnuity(){
        BigDecimal var=new BigDecimal(30000);
        creditInformation.setSumCredit(var);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate date=LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(date);
        return getAnnuityCalculation(creditInformation);
    }

    @Test
    void testSumCreditAnnuityCalculation(){
        List<OutInformationAboutCredit> testList= initValuesAnnuity();
        ArrayList<String> testSumCreditResult = new ArrayList<>();
        testSumCreditResult.add("30000");
        testSumCreditResult.add("27694.2338710579234");
        testSumCreditResult.add("25354.8617416632984");
        testSumCreditResult.add("22981.4325447040648");
        testSumCreditResult.add("20573.3458647971494");
        testSumCreditResult.add("18130.1309601815180");
        testSumCreditResult.add("15651.2564547776344");
        testSumCreditResult.add("13136.2518622606401");
        testSumCreditResult.add("10584.5692273345664");
        testSumCreditResult.add("7995.7521805993974");
        testSumCreditResult.add("5369.2416555819099");
        testSumCreditResult.add("2704.1744373813099");
        for (int i=0; i<testList.size();i++){
            assertEquals(testSumCreditResult.get(i), testList.get(i).getSumCredit().toString());
        }
    }

    @Test
    void testMonthlyPaymentAnnuityCalculation(){
        List<OutInformationAboutCredit> testList= initValuesAnnuity();
        ArrayList<String> testMonthlyPaymentResult = new ArrayList<>();
        testMonthlyPaymentResult.add("2743.2661289420766");
        testMonthlyPaymentResult.add("2743.2429627279585");
        testMonthlyPaymentResult.add("2743.175030292567");
        testMonthlyPaymentResult.add("2743.2262632402485");
        testMonthlyPaymentResult.add("2743.2378212822982");
        testMonthlyPaymentResult.add("2743.270338737217");
        testMonthlyPaymentResult.add("2743.2483425169944");
        testMonthlyPaymentResult.add("2743.2493015927403");
        testMonthlyPaymentResult.add("2743.1670467351687");
        testMonthlyPaymentResult.add("2743.1042750174875");
        testMonthlyPaymentResult.add("2743.365134867267");
        testMonthlyPaymentResult.add("2743.4333333333225");
        for (int i=0; i<testList.size();i++){
            assertEquals(testMonthlyPaymentResult.get(i), testList.get(i).getMonthlyPayment().toString());
        }
    }

    @Test
    void testPercentAnnuityCalculation(){
        List<OutInformationAboutCredit> testList= initValuesAnnuity();
        ArrayList<String> testPercentResult = new ArrayList<>();
        testPercentResult.add("437.5");
        testPercentResult.add("403.87083333333334");
        testPercentResult.add("369.74583333333334");
        testPercentResult.add("335.13958333333335");
        testPercentResult.add("300.0229166666667");
        testPercentResult.add("264.3958333333333");
        testPercentResult.add("228.24375");
        testPercentResult.add("191.56666666666666");
        testPercentResult.add("154.35");
        testPercentResult.add("116.59375");
        testPercentResult.add("78.29791666666667");
        testPercentResult.add("39.43333333333334");
        for (int i=0; i<testList.size();i++){
            assertEquals(testPercentResult.get(i), testList.get(i).getPercent().toString());
        }
    }

    @Test
    void testRepaymentAmountAnnuityCalculation(){
        List<OutInformationAboutCredit> testList= initValuesAnnuity();
        ArrayList<String> testRepaymentAmountResult = new ArrayList<>();
        testRepaymentAmountResult.add("2305.7661289420766");
        testRepaymentAmountResult.add("2339.372129394625");
        testRepaymentAmountResult.add("2373.4291969592336");
        testRepaymentAmountResult.add("2408.0866799069154");
        testRepaymentAmountResult.add("2443.2149046156314");
        testRepaymentAmountResult.add("2478.8745054038836");
        testRepaymentAmountResult.add("2515.0045925169943");
        testRepaymentAmountResult.add("2551.6826349260737");
        testRepaymentAmountResult.add("2588.817046735169");
        testRepaymentAmountResult.add("2626.5105250174875");
        testRepaymentAmountResult.add("2665.0672182006");
        testRepaymentAmountResult.add("2703.999999999989");
        for (int i=0; i<testList.size();i++){
            assertEquals(testRepaymentAmountResult.get(i), testList.get(i).getRepaymentAmount().toString());
        }
    }

    @Test
    void testDatePaymentAmountAnnuityCalculation(){
        List<OutInformationAboutCredit> testList= initValuesAnnuity();
        ArrayList<String> testDatePaymentAmountResult = new ArrayList<>();
        testDatePaymentAmountResult.add("2017-12-30");
        testDatePaymentAmountResult.add("2018-01-30");
        testDatePaymentAmountResult.add("2018-02-28");
        testDatePaymentAmountResult.add("2018-03-28");
        testDatePaymentAmountResult.add("2018-04-28");
        testDatePaymentAmountResult.add("2018-05-28");
        testDatePaymentAmountResult.add("2018-06-28");
        testDatePaymentAmountResult.add("2018-07-28");
        testDatePaymentAmountResult.add("2018-08-28");
        testDatePaymentAmountResult.add("2018-09-28");
        testDatePaymentAmountResult.add("2018-10-28");
        testDatePaymentAmountResult.add("2018-11-28");
        for (int i=0; i<testList.size();i++){
            assertEquals(testDatePaymentAmountResult.get(i), testList.get(i).getDatePayment().toString());
        }
    }

    List<OutInformationAboutCredit> initValuesDiff(){
        BigDecimal var=new BigDecimal(30000);
        creditInformation.setSumCredit(var);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate date=LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(date);
        return getDiffCalculation(creditInformation);
    }

    @Test
    void testSumCreditDiffCalculation(){
        List<OutInformationAboutCredit> testList= initValuesDiff();
        ArrayList<String> testSumCreditResult = new ArrayList<>();
        testSumCreditResult.add("30000");
        testSumCreditResult.add("27500.0");
        testSumCreditResult.add("25000.0");
        testSumCreditResult.add("22500.0");
        testSumCreditResult.add("20000.0");
        testSumCreditResult.add("17500.0");
        testSumCreditResult.add("15000.0");
        testSumCreditResult.add("12500.0");
        testSumCreditResult.add("10000.0");
        testSumCreditResult.add("7500.0");
        testSumCreditResult.add("5000.0");
        testSumCreditResult.add("2500.0");
        for (int i=0; i<testList.size();i++){
            assertEquals(testSumCreditResult.get(i), testList.get(i).getSumCredit().toString());
        }
    }

    @Test
    void testMonthlyPaymentDiffCalculation(){
        List<OutInformationAboutCredit> testList= initValuesDiff();
        ArrayList<String> testMonthlyPaymentResult = new ArrayList<>();
        testMonthlyPaymentResult.add("2937.5");
        testMonthlyPaymentResult.add("2901.0416666666665");
        testMonthlyPaymentResult.add("2864.5833333333335");
        testMonthlyPaymentResult.add("2828.125");
        testMonthlyPaymentResult.add("2791.6666666666665");
        testMonthlyPaymentResult.add("2755.2083333333335");
        testMonthlyPaymentResult.add("2718.75");
        testMonthlyPaymentResult.add("2682.2916666666665");
        testMonthlyPaymentResult.add("2645.8333333333335");
        testMonthlyPaymentResult.add("2609.375");
        testMonthlyPaymentResult.add("2572.9166666666665");
        testMonthlyPaymentResult.add("2536.4583333333335");
        for (int i=0; i<testList.size();i++){
            assertEquals(testMonthlyPaymentResult.get(i), testList.get(i).getMonthlyPayment().toString());
        }
    }

    @Test
    void testPercentDiffCalculation(){
        List<OutInformationAboutCredit> testList= initValuesDiff();
        ArrayList<String> testPercentResult = new ArrayList<>();
        testPercentResult.add("437.5");
        testPercentResult.add("401.0416666666667");
        testPercentResult.add("364.5833333333333");
        testPercentResult.add("328.125");
        testPercentResult.add("291.6666666666667");
        testPercentResult.add("255.20833333333334");
        testPercentResult.add("218.75");
        testPercentResult.add("182.29166666666666");
        testPercentResult.add("145.83333333333334");
        testPercentResult.add("109.375");
        testPercentResult.add("72.91666666666667");
        testPercentResult.add("36.458333333333336");
        for (int i=0; i<testList.size();i++){
            assertEquals(testPercentResult.get(i), testList.get(i).getPercent().toString());
        }
    }

    @Test
    void testRepaymentAmountDiffCalculation(){
        List<OutInformationAboutCredit> testList= initValuesDiff();
        ArrayList<String> testRepaymentAmountResult = new ArrayList<>();
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        testRepaymentAmountResult.add("2500.0");
        for (int i=0; i<testList.size();i++){
            assertEquals(testRepaymentAmountResult.get(i), testList.get(i).getRepaymentAmount().toString());
        }
    }

    @Test
    void testDatePaymentAmountDiffCalculation(){
        List<OutInformationAboutCredit> testList= initValuesDiff();
        ArrayList<String> testDatePaymentAmountResult = new ArrayList<>();
        testDatePaymentAmountResult.add("2017-12-30");
        testDatePaymentAmountResult.add("2018-01-30");
        testDatePaymentAmountResult.add("2018-02-28");
        testDatePaymentAmountResult.add("2018-03-28");
        testDatePaymentAmountResult.add("2018-04-28");
        testDatePaymentAmountResult.add("2018-05-28");
        testDatePaymentAmountResult.add("2018-06-28");
        testDatePaymentAmountResult.add("2018-07-28");
        testDatePaymentAmountResult.add("2018-08-28");
        testDatePaymentAmountResult.add("2018-09-28");
        testDatePaymentAmountResult.add("2018-10-28");
        testDatePaymentAmountResult.add("2018-11-28");
        for (int i=0; i<testList.size();i++){
            assertEquals(testDatePaymentAmountResult.get(i), testList.get(i).getDatePayment().toString());
        }
    }
}