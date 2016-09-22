package hu.schonherz.training.band.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by Attila on 2016.09.22..
 */
public class RemoteEJBLookup {

    public RemoteEJBLookup() {
    }

    public static <T> T lookup(Class<T> ejbClass, String appName, String moduleName,
                               String distinctName, String beanName) throws NamingException {
        final Hashtable Properties = new Hashtable();
        Properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        final Context context = new InitialContext(Properties);

        final String viewClassName = ejbClass.getName();

        return (T) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }
}
