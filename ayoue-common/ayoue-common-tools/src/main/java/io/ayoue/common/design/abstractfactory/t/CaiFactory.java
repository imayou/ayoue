package io.ayoue.common.design.abstractfactory.t;

public class CaiFactory extends AbstractFactory {

	@Override
	Cai getCai(String cai) {
		switch (cai) {
		case "BaiCai":
			return new BaiCai();
		case "QingCai":
			return new QingCai();
		case "YouCai":
			return new YouCai();
		default:
			return null;
		}
	}

	@Override
	Mi getMi(String mi) {
		// TODO Auto-generated method stub
		return null;
	}

}
