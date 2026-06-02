package qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

public class QRGenerator {

    public static void generateQR(
            String data,
            String path) {

        try {

            BitMatrix matrix =
                    new MultiFormatWriter()
                            .encode(
                                    data,
                                    BarcodeFormat.QR_CODE,
                                    300,
                                    300);

            BufferedImage image =
                    new BufferedImage(
                            300,
                            300,
                            BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < 300; x++) {

                for (int y = 0; y < 300; y++) {

                    image.setRGB(
                            x,
                            y,
                            matrix.get(x, y)
                                    ? 0x000000
                                    : 0xFFFFFF);
                }
            }

            ImageIO.write(
                    image,
                    "png",
                    new File(path));

            System.out.println(
                    "QR Generated!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}