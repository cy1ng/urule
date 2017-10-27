/*******************************************************************************
 * Copyright (C) 2017 Bstek.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.bstek.urule.model.function.impl;

import com.bstek.urule.Utils;
import com.bstek.urule.model.function.Argument;
import com.bstek.urule.model.function.FunctionDescriptor;
import com.bstek.urule.runtime.WorkingMemory;


/**
 * @author Jacky.gao
 * @since 2015年7月22日
 */
public class TrimFunctionDescriptor implements FunctionDescriptor{
	private boolean disabled=false;
	
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	@Override
	public String getLabel() {
		return "字符去空格";
	}
	@Override
	public String getName() {
		return "Trim";
	}
	@Override
	public Object doFunction(Object object, String property,WorkingMemory workingMemory) {
		Object value=Utils.getObjectProperty(object, property);
		if(value==null){
			return "null";
		}
		return value.toString().trim();
	}
	@Override
	public Argument getArgument() {
		Argument p=new Argument();
		p.setName("对象");
		p.setNeedProperty(true);
		return p;
	}
}
