package ru.fivkin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.fivkin.credit.dto.CreditInformation;
import ru.fivkin.credit.dto.OutInformationAboutCredit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.fivkin.Calculation.getAnnuityCalculation;
import static ru.fivkin.Calculation.getDiffCalculation;

class CalculationTest {

    @Test
    void testAnnuityCalculation() {
        List<OutInformationAboutCredit> testList = getAnnuityCalculation(new CreditInformation().sumCredit((BigDecimal.
                valueOf(30000))).loanPeriod(12).interestRate(17.5).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 30)));
        ArrayList<OutInformationAboutCredit> testAnnuityResult = new ArrayList<>();
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2017, Month.DECEMBER, 30)).
                monthlyPayment(new BigDecimal("2743.2661289420766")).repaymentAmount(new BigDecimal("2305.7661289420766")).
                percent(new BigDecimal("437.500000000000")).sumCredit(new BigDecimal("30000.0000000000000")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JANUARY, 30)).
                monthlyPayment(new BigDecimal("2743.2661289420783")).repaymentAmount(new BigDecimal("2339.3918849891503")).
                percent(new BigDecimal("403.874243952928")).sumCredit(new BigDecimal("27694.2338710579234")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.FEBRUARY, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420784")).repaymentAmount(new BigDecimal("2373.5080166452424")).
                percent(new BigDecimal("369.758112296836")).sumCredit(new BigDecimal("25354.8419860687731")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MARCH, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420782")).repaymentAmount(new BigDecimal("2408.1216752213182")).
                percent(new BigDecimal("335.144453720760")).sumCredit(new BigDecimal("22981.3339694235307")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.APRIL, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420829")).repaymentAmount(new BigDecimal("2443.2401163183009")).
                percent(new BigDecimal("300.026012623782")).sumCredit(new BigDecimal("20573.2122942022125")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MAY, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420803")).repaymentAmount(new BigDecimal("2478.8707013479403")).
                percent(new BigDecimal("264.395427594140")).sumCredit(new BigDecimal("18129.9721778839116")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JUNE, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420858")).repaymentAmount(new BigDecimal("2515.0208990759358")).
                percent(new BigDecimal("228.245229866150")).sumCredit(new BigDecimal("15651.1014765359713")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JULY, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420832")).repaymentAmount(new BigDecimal("2551.6982871874572")).
                percent(new BigDecimal("191.567841754626")).sumCredit(new BigDecimal("13136.0805774600355")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.AUGUST, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420875")).repaymentAmount(new BigDecimal("2588.9105538756125")).
                percent(new BigDecimal("154.355575066475")).sumCredit(new BigDecimal("10584.3822902725783")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.SEPTEMBER, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420902")).repaymentAmount(new BigDecimal("2626.6654994529682")).
                percent(new BigDecimal("116.600629489122")).sumCredit(new BigDecimal("7995.4717363969658")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.OCTOBER, 28)).
                monthlyPayment(new BigDecimal("2743.2661289420923")).repaymentAmount(new BigDecimal("2664.9710379866593")).
                percent(new BigDecimal("78.295090955433")).sumCredit(new BigDecimal("5368.8062369439976")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.NOVEMBER, 28)).
                monthlyPayment(new BigDecimal("2743.2661289421222")).repaymentAmount(new BigDecimal("2703.8351989573272")).
                percent(new BigDecimal("39.430929984795")).sumCredit(new BigDecimal("2703.8351989573383")));
        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testAnnuityResult, testList);
        }
    }

    @Test
    void testDiffCalculation() {
        List<OutInformationAboutCredit> testList = getDiffCalculation(new CreditInformation().sumCredit(BigDecimal.
                valueOf(30000)).loanPeriod(12).interestRate(17.5).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 30)));
        ArrayList<OutInformationAboutCredit> testDiffResult = new ArrayList<>();
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2017, Month.DECEMBER, 30)).
                monthlyPayment(new BigDecimal("2937.5000000000000")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("437.5000000000000")).sumCredit(new BigDecimal("30000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JANUARY, 30)).
                monthlyPayment(new BigDecimal("2901.0416666666667")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("401.0416666666667")).sumCredit(new BigDecimal("27500.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.FEBRUARY, 28)).
                monthlyPayment(new BigDecimal("2864.5833333333333")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("364.5833333333333")).sumCredit(new BigDecimal("25000.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MARCH, 28)).
                monthlyPayment(new BigDecimal("2828.1250000000000")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("328.1250000000000")).sumCredit(new BigDecimal("22500.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.APRIL, 28)).
                monthlyPayment(new BigDecimal("2791.6666666666667")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("291.6666666666667")).sumCredit(new BigDecimal("20000.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MAY, 28)).
                monthlyPayment(new BigDecimal("2755.2083333333333")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("255.2083333333333")).sumCredit(new BigDecimal("17500.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JUNE, 28)).
                monthlyPayment(new BigDecimal("2718.7500000000000")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("218.7500000000000")).sumCredit(new BigDecimal("15000.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JULY, 28)).
                monthlyPayment(new BigDecimal("2682.2916666666667")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("182.2916666666667")).sumCredit(new BigDecimal("12500.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.AUGUST, 28)).
                monthlyPayment(new BigDecimal("2645.8333333333333")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("145.8333333333333")).sumCredit(new BigDecimal("10000.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.SEPTEMBER, 28)).
                monthlyPayment(new BigDecimal("2609.3750000000000")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("109.3750000000000")).sumCredit(new BigDecimal("7500.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.OCTOBER, 28)).
                monthlyPayment(new BigDecimal("2572.9166666666667")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("72.9166666666667")).sumCredit(new BigDecimal("5000.0000000000000")));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.NOVEMBER, 28)).
                monthlyPayment(new BigDecimal("2536.4583333333333")).repaymentAmount(new BigDecimal("2500")).
                percent(new BigDecimal("36.4583333333333")).sumCredit(new BigDecimal("2500.0000000000000")));
        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testDiffResult,testList);
        }
    }

    static CreditInformation creditInformation = new CreditInformation().sumCredit(new BigDecimal("30000")).loanPeriod(12).interestRate(17.5).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28));

    @ParameterizedTest
    @MethodSource("provideValueSumCredit")
    void testValueSumCredit(CreditInformation creditInformation) {
        List<OutInformationAboutCredit> testList = getAnnuityCalculation(creditInformation);
        assertTrue(testList.isEmpty());
    }

    private static Stream<Arguments> provideValueSumCredit() {
        return Stream.of(
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(0))),
                Arguments.of(creditInformation.interestRate(0.0)),
                Arguments.of(creditInformation.loanPeriod(0)),
                Arguments.of(creditInformation.sumCredit(null)),
                Arguments.of(creditInformation.interestRate(null)),
                Arguments.of(creditInformation.loanPeriod(null)),
                Arguments.of(creditInformation.dateCredit(null)),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(-1))),
                Arguments.of(creditInformation.interestRate(-1.0)),
                Arguments.of(creditInformation.loanPeriod(-1))
        );
    }
}