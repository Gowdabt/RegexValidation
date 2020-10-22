/**
 * 
 */
package com.infrrd.service;

import com.fasterxml.jackson.core.format.InputAccessor;

import com.infrrd.model.Input;
import com.infrrd.model.Output;

/**
 * @author Harshith Gowda B T
 *
 */
public interface IRegexService {

	public Output validateandExtractRegex(Input input);

}
