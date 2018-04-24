package org.xiaomao.java.jndi;

import org.junit.Test;

import javax.naming.*;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {
    @Test
    public void test() {
        String[] rgstring = {"file:///c:/"};
        try {
            // Create the initial context.  The environment
            // information specifies the JNDI provider to use
            // and the initial URL to use (in our case, a
            // directory in URL form -- file:///...).
            Hashtable hashtableEnvironment = new Hashtable();
            hashtableEnvironment.put(
                    Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.dns.DnsContextFactory"
            );
            hashtableEnvironment.put(
                    Context.PROVIDER_URL,
                    rgstring[0]
            );
            Context context = new InitialContext(hashtableEnvironment);
            // If you provide no other command line arguments,
            // list all of the names in the specified context and
            // the objects they are bound to.
            if (rgstring.length == 1) {
                NamingEnumeration namingenumeration = context.listBindings("");
                while (namingenumeration.hasMore()) {
                    Binding binding = (Binding) namingenumeration.next();
                    System.out.println(
                            binding.getName() + " " +
                                    binding.getObject()
                    );
                }
            }
            // Otherwise, list the names and bindings for the
            // specified arguments.
            else {
                for (int i = 1; i < rgstring.length; i++) {
                    Object object = context.lookup(rgstring[i]);
                    System.out.println(
                            rgstring[i] + " " +
                                    object
                    );
                }
            }
            context.close();
        } catch (NamingException namingexception) {
            namingexception.printStackTrace();
        }
    }

    @Test
    public void test2() {
        String[] records = getRecords("devguerrilla.com", "A");
        for (int i = 0; i < records.length; i++) {
            System.out.println(records[i]);
        }
    }

    public String[] getRecords(String hostName, String type) {
        Set<String> results = new TreeSet<String>();
        try {
            Hashtable<String, String> envProps =
                    new Hashtable<String, String>();
            envProps.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.dns.DnsContextFactory");
            DirContext dnsContext = new InitialDirContext(envProps);
            Attributes dnsEntries = dnsContext.getAttributes(
                    hostName, new String[]{type});
            if (dnsEntries != null) {
                NamingEnumeration<?> dnsEntryIterator =
                        dnsEntries.get(type).getAll();
                while (dnsEntryIterator.hasMoreElements()) {
                    results.add(dnsEntryIterator.next().toString());
                }
            }
        } catch (NamingException e) {
            // Handle exception
        }
        return results.toArray(new String[results.size()]);
    }
}
