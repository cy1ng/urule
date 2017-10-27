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
package com.bstek.urule.runtime.rete;

import java.util.Collection;
import java.util.Map;

import com.bstek.urule.model.GeneralEntity;

/**
 * @author Jacky.gao
 * @since 2015年1月9日
 */
public class ObjectTypeActivity extends AbstractActivity {
	private Class<?> typeClass;
	private String clazz;
	public ObjectTypeActivity(String clazz){
		this.clazz=clazz;
	}
	public ObjectTypeActivity(Class<?> typeClass){
		this.typeClass=typeClass;
	}
	public Collection<FactTracker> enter(EvaluationContext context, Object obj,FactTracker tracker,Map<String,Object> variableMap) {
		return visitPahs(context,obj,tracker,variableMap);
	}
	public boolean support(Object object){
		if(typeClass==null && clazz==null){
			return true;
		}
		if(object instanceof GeneralEntity){
			GeneralEntity generalEntity=(GeneralEntity)object;
			String targetClass=generalEntity.getTargetClass();
			if(clazz!=null){
				if(targetClass.equals(clazz)){
					return true;
				}				
			}else{
				if(targetClass.equals(typeClass.getName())){
					return true;
				}
			}
		}else if(typeClass!=null && typeClass.isAssignableFrom(object.getClass())){
			return true;
		}
		return false;
	}
	@Override
	public boolean orNodeIsPassed() {
		return false;
	}
	@Override
	public void reset() {
	}
}
