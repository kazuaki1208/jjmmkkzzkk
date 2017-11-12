import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreateFileThread extends Thread {
	private String m_threadName;
	private String m_dir;
	private int m_siwakeCnt;

	public CreateFileThread(String threadName, String dir, int siwakeCnt) {
		m_threadName = threadName;
		m_dir = dir;
		m_siwakeCnt = siwakeCnt;
	}

	public synchronized void run() {
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		long start = System.currentTimeMillis();
		try {
			for (int i = 1; i <= m_siwakeCnt; i++) {
				File f = new File(String.format("%s\\%s-%03d.txt", m_dir, m_threadName, i));
				
				fos = new FileOutputStream(f);
				bw = new BufferedWriter(new OutputStreamWriter(fos));

				bw.write(f.getAbsolutePath() + "\r\n");
				bw.write(new String(new byte[20000]).toString());
				
			}
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.flush();
					fos.getFD().sync();
					bw.close();
					bw = null;
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		long total = System.currentTimeMillis() - start;
		System.out.println(String.format("%s,%d", m_threadName, total));
	}

	public static void main(String[] args) throws InterruptedException {
//		if (args.length != 2) {
//			System.out.println("Usage : CreateFileThread <dir> <siwakeCnt> <roopCnt>");
//		}

		String dir = "C:/Users/jmkzk/Documents/temp";
		int siwakeCnt = 10;
		int roopCnt = 1;

		for (int i = 1; i <= roopCnt; i++) {
			CreateFileThread t1 = new CreateFileThread(String.format("Thread-1-%03d", i), dir, siwakeCnt);
			CreateFileThread t2 = new CreateFileThread(String.format("Thread-2-%03d", i), dir, siwakeCnt);
			CreateFileThread t3 = new CreateFileThread(String.format("Thread-3-%03d", i), dir, siwakeCnt);
			CreateFileThread t4 = new CreateFileThread(String.format("Thread-4-%03d", i), dir, siwakeCnt);

			t1.start();
			t2.start();
			t3.start();
			t4.start();

			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}
	}

}
