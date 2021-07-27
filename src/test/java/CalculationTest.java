import java.util.*;

class CalculationTest {
    public static void main(String[] args) {
        testGetAnnuityCalculation();
    }

    private static void testGetAnnuityCalculation() {
        Calculation cal = new Calculation();
        Calendar calendar = new GregorianCalendar(2017, 0 , 25);

        List<Calculation> testList = cal.getAnnuityCalculation(30000, 17.5, 12, null);
        List<Calculation> testResultList = new ArrayList<>();

        Assert.assertEquals("Test List if data is null",testList,testResultList);

        List<Calculation> testListZeroFirst = cal.getAnnuityCalculation(0, 17.5, 12, calendar);
        List<Calculation> testResultListZeroFirst = new ArrayList<>();

        Assert.assertEquals("Test List if sum is 0",testListZeroFirst,testResultListZeroFirst);

        List<Calculation> testListZeroSecond = cal.getAnnuityCalculation(30000, 0, 12, calendar);
        List<Calculation> testResultListZeroSecond = new ArrayList<>();

        Assert.assertEquals("Test List if rate is 0",testListZeroSecond,testResultListZeroSecond);

        List<Calculation> testListZeroThird = cal.getAnnuityCalculation(30000, 17.5, 0, calendar);
        List<Calculation> testResultListZeroThird = new ArrayList<>();

        Assert.assertEquals("Test List if loanPeriod is 0", testListZeroThird,testResultListZeroThird);

        List<Calculation> testListMinusFirst = cal.getAnnuityCalculation(-1, 17.5, 12, calendar);
        List<Calculation> testResultListMinusFirst = new ArrayList<>();

        Assert.assertEquals("Test List if sum is -1",testListMinusFirst,testResultListMinusFirst);

        List<Calculation> testListMinusSecond = cal.getAnnuityCalculation(30000, -1, 12, calendar);
        List<Calculation> testResultListMinusSecond = new ArrayList<>();

        Assert.assertEquals("Test List if rate is -1",testListMinusSecond,testResultListMinusSecond);

        List<Calculation> testListMinusThird = cal.getAnnuityCalculation(30000, 17.5, -1, calendar);
        List<Calculation> testResultListMinusThird = new ArrayList<>();

        Assert.assertEquals("Test List if loanPeriod is -1", testListMinusThird,testResultListMinusThird);
    }
}