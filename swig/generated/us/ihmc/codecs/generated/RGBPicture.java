/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package us.ihmc.codecs.generated;

public class RGBPicture {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected RGBPicture(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RGBPicture obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ihmcVideoCodecsJNI.delete_RGBPicture(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public RGBPicture(int width, int height) {
    this(ihmcVideoCodecsJNI.new_RGBPicture(width, height), true);
  }

  public void put(java.nio.ByteBuffer src) {
  assert src.isDirect() : "Buffer must be allocated direct.";
    {
      ihmcVideoCodecsJNI.RGBPicture_put(swigCPtr, this, src);
    }
  }

  public void get(java.nio.ByteBuffer target) {
  assert target.isDirect() : "Buffer must be allocated direct.";
    {
      ihmcVideoCodecsJNI.RGBPicture_get(swigCPtr, this, target);
    }
  }

  public int getWidth() {
    return ihmcVideoCodecsJNI.RGBPicture_getWidth(swigCPtr, this);
  }

  public int getHeight() {
    return ihmcVideoCodecsJNI.RGBPicture_getHeight(swigCPtr, this);
  }

  public YUVPicture toYUV(YUVPicture.YUVSubsamplingType samplingType) {
    long cPtr = ihmcVideoCodecsJNI.RGBPicture_toYUV(swigCPtr, this, samplingType.swigValue());
    return (cPtr == 0) ? null : new YUVPicture(cPtr, true);
  }

}
