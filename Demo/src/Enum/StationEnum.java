package Enum;

/**
 * 车站的枚举信息 济南，泰山，徐州，南京，无锡，上海
 */
public enum StationEnum {

	Jinan(10000001), TaiShan(10000002), XuZhou(10000003), NanJing(10000004), WuXi(
			10000005), ShangHai(10000006);
	private int value = 0;

	private StationEnum(int value) { // 必须是private的，否则编译错误
		this.value = value;
	}

	public static StationEnum valueOf(int value) { // 手写的从int到enum的转换函数
		switch (value) {
		case 10000001:
			return Jinan;
		case 10000002:
			return TaiShan;
		case 10000003:
			return XuZhou;
		case 10000004:
			return NanJing;
		case 10000005:
			return WuXi;
		case 10000006:
			return ShangHai;
		default:
			return null;
		}
	}

	public int value() {
		return this.value;
	}

}
