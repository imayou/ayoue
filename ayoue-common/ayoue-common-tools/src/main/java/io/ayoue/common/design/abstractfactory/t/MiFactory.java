package io.ayoue.common.design.abstractfactory.t;

public class MiFactory extends AbstractFactory {

	@Override
	Cai getCai(String cai) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Mi getMi(String mi) {
		switch (mi) {
		case "NuoMi":
			return new NuoMi();
		case "XiaoMi":
			return new XiaoMi();
		case "ZiMi":
			return new ZiMi();
		default:
			return null;
		}
	}

}
