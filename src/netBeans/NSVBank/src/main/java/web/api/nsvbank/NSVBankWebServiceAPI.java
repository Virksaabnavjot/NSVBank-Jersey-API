//Project Github: https://github.com/Virksaabnavjot/NSVBank
package web.api.nsvbank;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:02 pm (Dublin,Ireland)
 */

@Path("bank")
@Produces("application/json")
public class NSVBankWebServiceAPI {
    public static final String bankName = "NSV Bank Ireland";
    @GET
    @Path("/")
    @Produces("application/json")
    public Response test(@Context UriInfo info){
        List <String> list = new ArrayList<>();
        String text = "You can use our online banking.Have a Good Day!!!!";
        list.add(bankName);
        list.add(text);
        Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(list)).build();
    }
}
