package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockRepository {

    public ArrayList<Double> findAll() {
        return StockFinder.getStockData(getStockNames());
    }

    private List<String> getStockNames() {
        String[] stockNames = "FCTY, FCCY, SRCE, FUBC, VNET, JOBS, EGHT, AVHI, SHLM, AAON, ASTM, ABAX, ABGB, ABMD, AXAS, ACTG, ACHC, ACAD, ACST, AXDX, XLRN, ACCL, ANCX, ARAY, ACRX, ACET, ACHN, ACIW, ACNB, ACOR, ACFN, ACTS, ACPW, ATVI, BIRT, ACUR, ACXM, ADMP, ADUS, AEY".split(", ");

        return Arrays.asList(stockNames);
    }
}
