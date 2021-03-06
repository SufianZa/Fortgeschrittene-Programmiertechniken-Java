package Helper;
import Services.ProductList;

/**
 * Created by Team 10
 */
public class IdGenerator {
    private static long id = 0;

    // returns first not used value between 0 and 999999
    // when all 999999 ids are used throw exception
    public static long generateID() throws IdOverFlowException {
        for (id = 1; id <= 999999; id++) {
            if(ProductList.getInstance().findProductById(id) == null) {
                return id;
            }
        }

        throw new IdOverFlowException();
    }
}
