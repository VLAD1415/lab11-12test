package service;

public class RegionCreator {
    public static final String TESTDATA_REGION = "testdata.region.name";

    public static String withCredentialsFromProperty(){
        return TestDataReader.getTestData(TESTDATA_REGION);
    }
}
