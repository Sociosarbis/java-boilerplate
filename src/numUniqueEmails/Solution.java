package numUniqueEmails;

import java.util.HashSet;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        var set = new HashSet<String>();
        var builder = new StringBuilder();
        var isIgnore = false;
        for (var email:emails) {
            for (var i = 0;i < email.length();i++) {
                if (email.charAt(i) == '@') {
                    builder.append(email.substring(i, email.length()));
                    var s = builder.toString();
                    if (!set.contains(s)) {
                        set.add(s);
                    }
                }
                if (!isIgnore) {
                    switch(email.charAt(i)) {
                        case '+':
                            isIgnore = true;
                            break;
                        case '.':
                            break;
                        default:
                            builder.append(email.charAt(i));
                    }
                }
            }
            isIgnore = false;
            builder.delete(0, builder.length());
        }
        return set.size();
    }    
}
