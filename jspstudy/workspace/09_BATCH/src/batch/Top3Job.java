package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.StudentDao;
import dto.Student;

public class Top3Job implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		// STUDENT 테이블에서 ave순으로 TOP3 가져오기
		List<Student> list = StudentDao.getInstance().selectTop3List();
		
		// list를 파일로 만들기
		File file = new File("top3.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (Student student : list) {
				bw.write(student.getSno() + ",");
				bw.write(student.getName() + ",");
				bw.write(student.getKor() + ",");
				bw.write(student.getEng() + ",");
				bw.write(student.getMat() + ",");
				bw.write(student.getAve() + ",");
				bw.write(student.getGrade() + "\n");
			}
			System.out.println("top3.txt 파일 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
