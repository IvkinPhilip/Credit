import org.junit.jupiter.api.Test;
import ru.fivkin.credit.dto.CreditInformation;
import ru.fivkin.credit.dto.OutInformationAboutCredit;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationTest {
    @Test
    void testNullSumCreditAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(null);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testNullInterestRateAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(null);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testNullLoanPeriodAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(null);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testNullDateCreditAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        creditInformation.setDateCredit(null);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testZeroSumCreditAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(0.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testZeroInterestRateAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(0.0);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testZeroLoanPeriodAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(0);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testMinusSumCreditAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(0.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testMinusInterestRateAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(0.0);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testMinusLoanPeriodAnnuityCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(0);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testNullSumCreditDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(null);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testNullInterestRateDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(null);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testNullLoanPeriodDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(null);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testNullDateCreditDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        creditInformation.setDateCredit(null);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testZeroSumCreditDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(0.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testZeroInterestRateDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(0.0);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testZeroLoanPeriodDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(0);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testMinusSumCreditDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(0.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testMinusInterestRateDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(0.0);
        creditInformation.setLoanPeriod(12);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }

    @Test
    void testMinusLoanPeriodDiffCalculation() {
        CreditInformation creditInformation = new CreditInformation();
        creditInformation.setSumCredit(30000.0);
        creditInformation.setInterestRate(17.5);
        creditInformation.setLoanPeriod(0);
        LocalDate dateCredit = LocalDate.of(2017, Month.NOVEMBER, 30);
        creditInformation.setDateCredit(dateCredit);

        List<OutInformationAboutCredit> testListCalculation = new ArrayList<>();

        assertEquals(Calculation.getAnnuityCalculation(creditInformation), testListCalculation);
    }
}