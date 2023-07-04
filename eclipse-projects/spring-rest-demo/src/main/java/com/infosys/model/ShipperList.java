package com.infosys.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.infosys.entity.Shipper;

import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "shippers")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
public class ShipperList {

	@XmlElement(name = "shipper")
	private List<Shipper> shippers;

	public ShipperList(List<Shipper> shippers) {
		this.shippers = shippers;
	}

}
