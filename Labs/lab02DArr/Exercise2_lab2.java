
public class Exercise2_lab2 {

	public static enum LetterGrade {
		A("A", 90), B("B", 80), C("C", 70), D("D", 60);

		private String string;
		private int integer;

		private LetterGrade(String string, int integer) {
			this.string = string;
			this.integer = integer;
		}
	};

	public static void main(String args[]) {

		// r:s, c:grade
		double[][] student_marks = {

				{ 75, 86, 92, 78, 69 }, // s1
				{ 66, 77, 88, 99, 55 }, // s2
				{ 78, 87, 95, 89, 55 }, // s3
				{ 88, 99, 67, 89, 75 } // s4
		};

		// Tasks:

		// 1. find the letter grades of each students for each subjects
		// 2. find the average marks for each subjects
		// 3. for each subjects, find index of the student who get highest grade in that
		// subject
		// 4. for each subjects, find index of two students who get lowest grade in that
		// subject
		// 5. find index of 2 students with lowest total grades

		letter_grades(student_marks);

		System.out.println();

		subject_avg(student_marks);

		System.out.println();

		lowest_grade_each_subject(student_marks);

		System.out.println();

		two_lowest_grade_each_subject(student_marks);

		System.out.println();

		two_lowest_total_grades(student_marks);

	}

	public static void letter_grades(double[][] student_marks) {

		for (int i = 0; i < student_marks.length; i++) {
			LetterGrade A = LetterGrade.A;
			LetterGrade B = LetterGrade.B;
			LetterGrade C = LetterGrade.C;
			LetterGrade D = LetterGrade.D;
			System.out.println("Student " + (i + 1));
			for (int j = 0; i < student_marks[i].length; j++) {
				if (student_marks[i][j] >= A.integer) {
					System.out.printf(A.string);
				} else if (student_marks[i][j] >= B.integer) {
					System.out.printf(B.string);
				} else if (student_marks[i][j] >= C.integer) {
					System.out.printf(C.string);
				} else if (student_marks[i][j] >= D.integer) {
					System.out.printf(D.string);
				} else {
					System.out.printf("F");
				}
			}
			System.out.println();
		}

	}

	public static void subject_avg(double[][] student_marks) {

		double sum = 0;
		for (int i = 0; i < student_marks.length; i++) {
			for (int j = 0; i < student_marks[i].length; j++) {
				sum += student_marks[i][j];
			}
			System.out.println("Student " + (i + 1) + "average: " + sum / student_marks[0].length);
			sum = 0;
		}
	}

	public static void lowest_grade_each_subject(double[][] student_marks) {
		double lowest = 0;
		for (int i = 0; i < student_marks.length; i++) {
			lowest = student_marks[i][0];
			for (int j = 1; i < student_marks[i].length; j++) {
				if (student_marks[i][j] < lowest) {
					lowest = student_marks[i][j];
				}
			}
			System.out.println("Student " + (i + 1) + "lowest: " + lowest);
		}
	}

	public static void two_lowest_grade_each_subject(double[][] student_marks) {

	}

	public static void two_lowest_total_grades(double[][] student_marks) {

	}

}