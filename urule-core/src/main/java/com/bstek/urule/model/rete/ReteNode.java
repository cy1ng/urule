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
package com.bstek.urule.model.rete;

import java.util.Map;

import com.bstek.urule.model.Node;
import com.bstek.urule.runtime.rete.Activity;

/**
 * @author Jacky.gao
 * @since 2015年1月12日
 */
public abstract class ReteNode implements Node {
	private int id;
	public ReteNode(int id){
		this.id=id;
	}
	public abstract NodeType getNodeType();
	public abstract Activity newActivity(Map<Object,Object> context);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
