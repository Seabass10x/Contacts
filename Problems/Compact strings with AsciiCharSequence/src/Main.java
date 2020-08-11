import java.lang.reflect.Array;
import java.util.*;

class AsciiCharSequence implements CharSequence {

    private byte[] sequence;

    public AsciiCharSequence(byte[] sequence) {
        this.sequence = sequence;
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int i) {
        return (char) Array.getByte(sequence, i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] slice = Arrays.copyOfRange(sequence, i, i1);
        return new AsciiCharSequence(slice);
    }

    @Override
    public String toString() {
        return new String(sequence);
    }
}