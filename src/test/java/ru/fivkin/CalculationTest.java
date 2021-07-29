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
        List<OutInformationAboutCredit> testList = getAnnuityCalculation(new CreditInformation().sumCredit(BigDecimal.
                valueOf(30000)).loanPeriod(12).interestRate(17.5).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 30)));
        ArrayList<OutInformationAboutCredit> testAnnuityResult = new ArrayList<>();
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2017, Month.DECEMBER, 30)).
                monthlyPayment(2743.2661289420766).repaymentAmount(2305.7661289420766).percent(437.5).sumCredit(new BigDecimal("30000")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JANUARY, 30)).
                monthlyPayment(2743.2429627279585).repaymentAmount(2339.372129394625).percent(403.87083333333334).sumCredit(new BigDecimal("27694.2338710579234")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.FEBRUARY, 28)).
                monthlyPayment(2743.175030292567).repaymentAmount(2373.4291969592336).percent(369.74583333333334).sumCredit(new BigDecimal("25354.8617416632984")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MARCH, 28)).
                monthlyPayment(2743.2262632402485).repaymentAmount(2408.0866799069154).percent(335.13958333333335).sumCredit(new BigDecimal("22981.4325447040648")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.APRIL, 28)).
                monthlyPayment(2743.2378212822982).repaymentAmount(2443.2149046156314).percent(300.0229166666667).sumCredit(new BigDecimal("20573.3458647971494")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MAY, 28)).
                monthlyPayment(2743.270338737217).repaymentAmount(2478.8745054038836).percent(264.3958333333333).sumCredit(new BigDecimal("18130.1309601815180")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JUNE, 28)).
                monthlyPayment(2743.2483425169944).repaymentAmount(2515.0045925169943).percent(228.24375).sumCredit(new BigDecimal("15651.2564547776344")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JULY, 28)).
                monthlyPayment(2743.2493015927403).repaymentAmount(2551.6826349260737).percent(191.56666666666666).sumCredit(new BigDecimal("13136.2518622606401")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.AUGUST, 28)).
                monthlyPayment(2743.1670467351687).repaymentAmount(2588.817046735169).percent(154.35).sumCredit(new BigDecimal("10584.5692273345664")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.SEPTEMBER, 28)).
                monthlyPayment(2743.1042750174875).repaymentAmount(2626.5105250174875).percent(116.59375).sumCredit(new BigDecimal("7995.7521805993974")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.OCTOBER, 28)).
                monthlyPayment(2743.365134867267).repaymentAmount(2665.0672182006).percent(78.29791666666667).sumCredit(new BigDecimal("5369.2416555819099")));
        testAnnuityResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.NOVEMBER, 28)).
                monthlyPayment(2743.4333333333225).repaymentAmount(2703.999999999989).percent(39.43333333333334).sumCredit(new BigDecimal("2704.1744373813099")));
        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testAnnuityResult.get(i), testList.get(i));
        }
    }

    @Test
    void testDiffCalculation() {
        List<OutInformationAboutCredit> testList = getDiffCalculation(new CreditInformation().sumCredit(BigDecimal.
                valueOf(30000)).loanPeriod(12).interestRate(17.5).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 30)));
        ArrayList<OutInformationAboutCredit> testDiffResult = new ArrayList<>();
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2017, Month.DECEMBER, 30)).
                monthlyPayment(2937.5).repaymentAmount(2500.0).percent(437.5).sumCredit(BigDecimal.valueOf(30000)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JANUARY, 30)).
                monthlyPayment(2901.0416666666665).repaymentAmount(2500.0).percent(401.0416666666667).sumCredit(BigDecimal.valueOf(27500.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.FEBRUARY, 28)).
                monthlyPayment(2864.5833333333335).repaymentAmount(2500.0).percent(364.5833333333333).sumCredit(BigDecimal.valueOf(25000.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MARCH, 28)).
                monthlyPayment(2828.125).repaymentAmount(2500.0).percent(328.125).sumCredit(BigDecimal.valueOf(22500.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.APRIL, 28)).
                monthlyPayment(2791.6666666666665).repaymentAmount(2500.0).percent(291.6666666666667).sumCredit(BigDecimal.valueOf(20000.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.MAY, 28)).
                monthlyPayment(2755.2083333333335).repaymentAmount(2500.0).percent(255.20833333333334).sumCredit(BigDecimal.valueOf(17500.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JUNE, 28)).
                monthlyPayment(2718.75).repaymentAmount(2500.0).percent(218.75).sumCredit(BigDecimal.valueOf(15000.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.JULY, 28)).
                monthlyPayment(2682.2916666666665).repaymentAmount(2500.0).percent(182.29166666666666).sumCredit(BigDecimal.valueOf(12500.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.AUGUST, 28)).
                monthlyPayment(2645.8333333333335).repaymentAmount(2500.0).percent(145.83333333333334).sumCredit(BigDecimal.valueOf(10000.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.SEPTEMBER, 28)).
                monthlyPayment(2609.375).repaymentAmount(2500.0).percent(109.375).sumCredit(BigDecimal.valueOf(7500.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.OCTOBER, 28)).
                monthlyPayment(2572.9166666666665).repaymentAmount(2500.0).percent(72.91666666666667).sumCredit(BigDecimal.valueOf(5000.0)));
        testDiffResult.add(new OutInformationAboutCredit().datePayment(LocalDate.of(2018, Month.NOVEMBER, 28)).
                monthlyPayment(2536.4583333333335).repaymentAmount(2500.0).percent(36.458333333333336).sumCredit(BigDecimal.valueOf(2500.0)));
        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testDiffResult.get(i), testList.get(i));
        }
    }

    static CreditInformation creditInformation = new CreditInformation().sumCredit(new BigDecimal("30000")).loanPeriod(12).interestRate(17.5).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28));

    @ParameterizedTest
    @MethodSource("provideValueSumCredit")
    void testValueSumCredit(CreditInformation creditInformation) {
        List<OutInformationAboutCredit> testList =getAnnuityCalculation(creditInformation);
        assertTrue(testList.isEmpty());
    }

    private static Stream<Arguments> provideValueSumCredit() {
        return Stream.of(
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(0)).interestRate(17.5).loanPeriod(12).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(30000)).interestRate(0.0).loanPeriod(12).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(30000)).interestRate(17.5).loanPeriod(0).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(null).interestRate(17.5).loanPeriod(12).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(30000)).interestRate(null).loanPeriod(12).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(30000)).interestRate(17.5).loanPeriod(null).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(30000)).interestRate(17.5).loanPeriod(12).dateCredit(null)),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(-1)).interestRate(17.5).loanPeriod(12).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(30000)).interestRate(-1.0).loanPeriod(12).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28))),
                Arguments.of(creditInformation.sumCredit(BigDecimal.valueOf(30000)).interestRate(17.5).loanPeriod(-1).dateCredit(LocalDate.of(2017, Month.NOVEMBER, 28)))
        );
    }
}