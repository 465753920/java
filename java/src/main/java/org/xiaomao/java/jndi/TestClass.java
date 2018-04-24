package org.xiaomao.java.jndi;

import com.sun.jndi.dns.DnsContext;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {
    @Test
    public void test() {
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
                    "dns://211.136.192.6"
            );
            InitialDirContext context = new InitialDirContext(hashtableEnvironment);
            Attributes attrs = context.getAttributes("baidu.com", new String[]{"A"});
            if (attrs != null) {
                NamingEnumeration<?> dnsEntryIterator =
                        attrs.get("A").getAll();
                while (dnsEntryIterator.hasMoreElements()) {
                    System.out.println(dnsEntryIterator.next().toString());
                }
            }

            context.close();
        } catch (NamingException namingexception) {
            namingexception.printStackTrace();
        }
    }

    @Test
    public void test2() {
        String[] records = getRecords("baidu.com", "A");
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
            Object o = dnsContext.lookup("baidu.com");
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
