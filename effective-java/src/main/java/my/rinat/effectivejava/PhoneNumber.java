package my.rinat.effectivejava;

class PhoneNumber {

    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    private int hashCode;

    PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber that = (PhoneNumber) obj;
        return this.areaCode == that.areaCode
                && this.prefix == that.prefix
                && this.lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }
}
