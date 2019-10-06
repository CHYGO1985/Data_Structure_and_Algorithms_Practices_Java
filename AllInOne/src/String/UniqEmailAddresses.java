package String;

import java.util.HashSet;
import java.util.Set;

public class UniqEmailAddresses {
	public int numUniqueEmails(String[] emails) {
        
		Set<String> mails = new HashSet<>();
        
        for (String email : emails) {
            StringBuilder builder = new StringBuilder();
        	int atIndx = email.indexOf('@');
        	builder.insert(0, email.substring(atIndx));
        	String start = email.substring(0, email.substring(0, atIndx).indexOf('+')).replace(".", "");
        	builder.insert(0, start);
            System.out.println(builder.toString());
        	mails.add(builder.toString());
        }
        
        return mails.size();
    }
}
