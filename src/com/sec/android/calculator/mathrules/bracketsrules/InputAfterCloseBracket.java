package com.sec.android.calculator.mathrules.bracketsrules;

import android.text.Editable;
import com.sec.android.calculator.utils.BasicRules;

/**
 * @author Ganna Pliskovska(g.pliskovska@samsung.com)
 */
public class InputAfterCloseBracket extends BasicRules {

    @Override
    public boolean applyRule(Editable s, int cursorPosition) {
        //prohibit input symbol after ")" if it's not [*/+-^%] or [)]
        if (cursorPosition > 1 && isDesiredCharBracket(s, cursorPosition, 2, ")") &&
                !isDesiredCharOperator(s, cursorPosition, 1) &&
                !isDesiredCharBracket(s, cursorPosition, 1, ")")){
            prohibitSymbolInput(s, cursorPosition);
            return true;
        }
        return false;
    }
}
