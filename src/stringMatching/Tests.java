package stringMatching;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

class Suite {
    String[] words;
    List<String> ret;

    Suite(String[] words, List<String> ret) {
        this.words = words;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[] {
                new Suite(
                    new String[] {
                        "mass", "as", "hero", "superhero"
                    }, 
                    List.of(
                        "as", "hero"
                    )
                ),
                new Suite(
                    new String[] {
                        "leetcode","et","code"
                    }, 
                    List.of(
                        "et", "code"
                    )
                ),
                new Suite(
                    new String[] {
                        "blue","green","bu"
                    },
                    List.of()
                ),
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.stringMatching(su.words));
        }
    }
}
