package cn.hutool.core.io.file;

import cn.hutool.core.io.FileUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathUtilTest {

	@Test
	@Disabled
	public void copyFileTest(){
		PathUtil.copyFile(
				Paths.get("d:/test/1595232240113.jpg"),
				Paths.get("d:/test/1595232240113_copy.jpg"),
				StandardCopyOption.COPY_ATTRIBUTES,
				StandardCopyOption.REPLACE_EXISTING
				);
	}

	@Test
	@Disabled
	public void copyTest(){
		PathUtil.copy(
				Paths.get("d:/Red2_LYY"),
				Paths.get("d:/test/aaa/aaa.txt")
		);
	}

	@Test
	@Disabled
	public void copyContentTest(){
		PathUtil.copyContent(
				Paths.get("d:/Red2_LYY"),
				Paths.get("d:/test/aaa/")
		);
	}

	@Test
	@Disabled
	public void moveTest(){
		PathUtil.move(Paths.get("d:/lombok.jar"), Paths.get("d:/test/"), false);
	}

	@Test
	@Disabled
	public void moveDirTest(){
		PathUtil.move(Paths.get("c:\\aaa"), Paths.get("d:/test/looly"), false);
	}

	@Test
	@Disabled
	public void delDirTest(){
		PathUtil.del(Paths.get("d:/test/looly"));
	}

	@Test
	@Disabled
	public void getMimeTypeTest(){
		String mimeType = PathUtil.getMimeType(Paths.get("d:/test/test.jpg"));
		assertEquals("image/jpeg", mimeType);

		mimeType = PathUtil.getMimeType(Paths.get("d:/test/test.mov"));
		assertEquals("video/quicktime", mimeType);
	}

	@Test
	public void getMimeOfRarTest(){
		String contentType = FileUtil.getMimeType("a001.rar");
		assertEquals("application/x-rar-compressed", contentType);
	}

	@Test
	public void getMimeOf7zTest(){
		String contentType = FileUtil.getMimeType("a001.7z");
		assertEquals("application/x-7z-compressed", contentType);
	}

	@Test
	public void issue3179Test() {
		final String mimeType = PathUtil.getMimeType(Paths.get("xxxx.jpg"));
		assertEquals("image/jpeg", mimeType);
	}

	/**
	 * issue#2893 target不存在空导致异常
	 */
	@Test
	@Disabled
	public void moveTest2(){
		PathUtil.move(Paths.get("D:\\project\\test1.txt"), Paths.get("D:\\project\\test2.txt"), false);
	}
}
