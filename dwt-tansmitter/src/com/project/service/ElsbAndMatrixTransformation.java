package com.project.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ElsbAndMatrixTransformation {

	private static final int BITS_IN_BYTE = 4;

	public static void main(String[] args) throws IOException {

		byte[] getPixelOfImage = ElsbAndMatrixTransformation.getPixel();

		//System.out.println("Pixel Of Image In String :: " + getPixelOfImage.toString());
		System.out.println("Pixel Of Image In Matrix Format :: "+Arrays.toString(getPixelOfImage));
		
		//System.out.println("Pixel Count Is :: " + getPixelOfImage.length);
		
		int numberOfBytes = (getPixelOfImage.length + BITS_IN_BYTE - 1) / BITS_IN_BYTE;
		
		//System.out.println("Number Of Bytes Is :: " + numberOfBytes);
		

	}

	public static byte[] extractLSBRL(final int perByte, final int[] pixels) {
		final int outSize = (pixels.length + perByte - 1) / perByte;
		final byte[] lsbs = new byte[outSize];
		for (int i = 0; i < pixels.length; i++) {
			// which output byte is the one for this pixel
			final int j = i / perByte;
			// make space for the new bit to arrive.
			lsbs[j] <<= 1;
			// copy the bit in to the output byte's position.
			lsbs[j] |= pixels[i] & 1;

			System.out.println("Least Significant Beat :: " + lsbs.toString());

		}
		return lsbs;

	}

	public static byte[] getPixel() throws IOException {

		BufferedImage imgBuffer = ImageIO.read(new File("E:\\ETS-Project\\Project\\3. Image Compression Using DWT\\monalisa.jpg"));

		byte[] pixels = (byte[]) imgBuffer.getRaster().getDataElements(0, 0, imgBuffer.getWidth(),
				imgBuffer.getHeight(), null);

		return pixels;
	}

}
