/**
 * 
 */
package com.infrrd.service;

import java.util.regex.*;

import org.springframework.stereotype.Service;

import com.infrrd.model.Input;
import com.infrrd.model.Output;

/**
 * @author Harshith Gowda B T
 *
 */
@Service
public class RegexServiceImpl implements IRegexService {

	@Override
	public Output validateandExtractRegex(Input input) {
		String regexdata = input.getRegex();
		Output output = new Output();
		if (validateRegex(regexdata)) {
			output = getMatchedRegex(input);

		} else {
			output.setError(true);
		}
		return output;
	}

	/**
	 * @param textBody
	 * @return
	 */
	private Output getMatchedRegex(Input input) {
		Output output = new Output();
		output.setError(false);
		if (!input.getTextBody().isEmpty()) {
			Pattern p = Pattern.compile(input.getRegex());
			Matcher matcher = p.matcher(input.getTextBody());
			if (matcher.find()) {
				output.setMatch(matcher.group());
			} else {
				output.setMatch(null);
			}
		} else {
			output.setMatch(null);
		}
		return output;
	}

	/**
	 * @param regexdata
	 * @return
	 */
	private boolean validateRegex(String regexdata) {
		boolean result = true;
		try {
			Pattern.compile(regexdata);
		} catch (PatternSyntaxException exception) {
			result = false;
		}
		return result;
	}

}
