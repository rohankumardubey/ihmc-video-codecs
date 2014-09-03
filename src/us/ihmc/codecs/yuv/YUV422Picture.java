package us.ihmc.codecs.yuv;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import com.google.code.libyuv.FilterModeEnum;
import com.google.code.libyuv.libyuv;

public class YUV422Picture extends YUVPicture
{
   private final ByteBuffer Y, U, V;

   public YUV422Picture(ByteBuffer Y, ByteBuffer U, ByteBuffer V, int yStride, int uStride, int vStride, int w, int h)
   {
      super(w, h, yStride, uStride, vStride);
      this.Y = Y;
      this.U = U;
      this.V = V;
   }

   public YUV422Picture(BufferedImage orig)
   {
      super(orig.getWidth(), orig.getHeight(), orig.getWidth(), orig.getWidth(), orig.getWidth());

      Y = ByteBuffer.allocateDirect(yStride * h);
      U = ByteBuffer.allocateDirect(uStride * h);
      V = ByteBuffer.allocateDirect(vStride * h);

      ByteBuffer src = getARGBBuffer(orig);

      int srcStride = w * 3;
      libyuv.ARGBToI422(src, srcStride, Y, yStride, U, uStride, V, vStride, w, h);

   }

   @Override
   public YUV422Picture scale(int newWidth, int newHeight, FilterModeEnum filterMode)
   {
      if ((newWidth >> 1) << 1 != newWidth || (newHeight >> 1) << 1 != newHeight)
      {
         throw new RuntimeException("Resolution not divisible by 2");
      }

      int yStrideDest = newWidth;
      int uStrideDest = yStrideDest >> 1;
      int vStrideDest = yStrideDest >> 1;

      ByteBuffer Ydest = ByteBuffer.allocateDirect(yStrideDest * newHeight);
      ByteBuffer Udest = ByteBuffer.allocateDirect(uStrideDest * newHeight);
      ByteBuffer Vdest = ByteBuffer.allocateDirect(vStrideDest * newHeight);

      libyuv.ScalePlane(Y, yStride, w, h, Ydest, yStrideDest, newWidth, newHeight, filterMode);
      libyuv.ScalePlane(U, uStride, w, h, Udest, uStrideDest, newWidth / 2, newHeight, filterMode);
      libyuv.ScalePlane(V, vStride, w, h, Vdest, vStrideDest, newWidth / 2, newHeight, filterMode);

      return new YUV422Picture(Ydest, Udest, Vdest, yStrideDest, uStrideDest, vStrideDest, newWidth, newHeight);

   }

   @Override
   public BufferedImage getImage()
   {
      int dstStride = w * 4;
      ByteBuffer dstBuffer = ByteBuffer.allocateDirect(dstStride * h);

      libyuv.I422ToARGB(Y, yStride, U, uStride, V, vStride, dstBuffer, dstStride, w, h);

      BufferedImage img = createBGRBufferedImageFromRGBA(dstBuffer);

      return img;
   }

   @Override
   public ByteBuffer getY()
   {
      return Y;
   }

   @Override
   public ByteBuffer getU()
   {
      return U;
   }

   @Override
   public ByteBuffer getV()
   {
      return V;
   }

}