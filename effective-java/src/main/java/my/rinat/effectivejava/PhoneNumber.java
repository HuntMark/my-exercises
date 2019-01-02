package my.rinat.effectivejava;

class PhoneNumber implements Comparable<PhoneNumber> {

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

    @Override
    public int compareTo(PhoneNumber that) {
        int result = Short.compare(this.areaCode, that.areaCode);
        if (result == 0) {
            result = Short.compare(this.prefix, that.prefix);
            if (result == 0) {
                result = Short.compare(this.lineNum, that.lineNum);
            }
        }
        return result;
    }
}
