/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.codecs.generated;

public enum FilterModeEnum {
  kFilterNone(0),
  kFilterLinear(1),
  kFilterBilinear(2),
  kFilterBox(3);

  public final int swigValue() {
    return swigValue;
  }

  public static FilterModeEnum swigToEnum(int swigValue) {
    FilterModeEnum[] swigValues = FilterModeEnum.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (FilterModeEnum swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + FilterModeEnum.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private FilterModeEnum() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private FilterModeEnum(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private FilterModeEnum(FilterModeEnum swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

