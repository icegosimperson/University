Group by : SQL에서 특정 칼럼의 동일한 값을 갖는 행을 그룹화 하는데 사용

SELECT column1, column2, aggrate_function(SUM(), AVG(), COUNT(), MAX(), MIN()...)
FROM table_name
WHERE condition
GROUP BY column, column2 (어떤 기준으로 결과를 볼 것인가)

Orders 테이블에서 각 제품별로 팔린 총 수량을 알고 싶을 때

SELECT product_name, SUM(quantity)
FROM orders
GROUP BY product_name


1. 각 제품별로 판매된 총 수량을 구하세요.
SELECT product_name, SUM(quantity)
FROM orders
GROUP BY product_name

2. 각 고객별로 주문한 총 제품 수량을 구하세요.
SELECT customer_name, SUM(quantity) 
FROM orders
GROUP BY customer_name

3. 
각 제품별로 주문을 한 고객의 수를 구하세요. (예: Apple을 주문한 고객 수)
SELECT product_name, COUNT(DISTINCT customer_name)
FROM orders 
GROUP BY product_name;

4. 각 제품별로 판매된 총 수량이 5 이상인 제품과 해당 수량을 구하세요.
SELECT product_name, SUM(quantity) as total_quantity
FROM orders
GROUP BY product_name
WHERE quantity>=5;

- JOIN : SQL에서 두개 이상의 테이블에서 데이터를 결합하기 위해 사용하는 연산자
SELECT <열 목록>
FROM <첫번째 테이블>
	INNER JOIN <두번째 테이블>
	ON <조인될 조건>
[WHERE 검색조건]

1) INNER JOIN :  두 테이블에서 지정된 조건을 만족하는 행만 반환
2) LEFT JOIN : 왼쪽 테이블의 모든 행과, 오른쪽 테이블에서 조건에 맞는 행을 반환, 오른쪽 테이블에 일치하는 행이 없는 경우에는 NULL반환

EX) students 테이블과 courses 테이블을 student_id를 기준으로 JOIN하려면 다음과 같이 쿼리를 작성합니다:
SELECT stduent_name, courses_name
FROM students (기준 테이블)
INNER JOIN courses ON student.students_id = courses.students_id;



1. 모든 학생의 이름과 그 학생이 수강하는 과목 이름을 선택하세요.
SELECT  students.student_name, course.course_name
FROM students
	INNER JOIN courses  
	ON students.students_id = course.course_id



2. Mathematics를 수강하는 학생들의 이름을 선택하세요.
SELECT students.students_name
FROM students
	INNER JOIN courses
	ON students.students_id = courses.student_id
	WHERE courses.course_name = 'Mathematics';


3. 과목을 수강하지 않는 학생의 이름을 선택하세요.
SELECT studetns.student_name
FROM students
	LEFT JOIN courses
	ON  students.student_id = courses.students_id
	WHERE courses.course_id = 'NULL';

4. 각 학생별로 수강하는 과목의 수를 구하세요.
SELECT studetns.student_name, COUNT(course.course_name) AS number_of_course
FROM studetns
	LEFT JOIN course 
	ON students.student_id = courses.course_name





1. 각 학생의 모든 과목에 대한 점수 평균 출력
SELECT s.student_id, AVG(cs.score) AS average_score
FROM students s
JOIN course_scores cs ON s.student_id = cs.student_id
GROUP BY s.student_id;


2. 전체 학생의 Mathematics 점수의 평균 출력
SELECT AVG(score) AS math_average_score
FROM course_scores
WHERE course_name = 'Mathematics';


3. 평균 점수가 70점 이상인 학생만 선택
SELECT s.student_name, AVG(cs.score) AS average_score
FROM students s
JOIN course_scores cs ON s.student_id = cs.student_id
GROUP BY s.student_name
HAVING AVG(cs.score) >= 70;


4. 평균 점수가 전체 평균보다 낮은 학생의 이름을 출력
WITH OverallAverage AS (
	SELECT AVG(score) AS overall_avg
	FROM course_scores
)
SELECT s.student_name, AVG(cs.score) AS student_average_score
FROM students s
JOIN course_scores cs ON s.student_id = cs.student_id
GROUP BY s.student_name
HAVING AVG(cs.score) < (SELECT overall_avg FROM OverallAverage);



1. 각 과목별로 가장 높은 점수를 받은 학생의 이름을 출력하세요.
WITH MaxScores AS (
    SELECT course_name, MAX(score) as max_score
    FROM course_scores
    GROUP BY course_name
)
SELECT s.student_name, m.course_name, m.max_score
FROM students s
JOIN course_scores cs ON s.student_id = cs.student_id
JOIN MaxScores m ON m.course_name = cs.course_name AND m.max_score = cs.score;



2. 각 학생이 받은 총점의 합계를 출력하세요.
SELECT s.student_name, SUM(cs.score) as total_score
FROM students s
JOIN course_scores cs ON s.student_id = cs.student_id
GROUP BY s.student_name;



3. 각 과목별 학생들의 점수의 중간값을 출력하세요. 
WITH OrderedScores AS (
    SELECT cs.course_name, cs.score,
    ROW_NUMBER() OVER(PARTITION BY cs.course_name ORDER BY cs.score) as row_asc,
    ROW_NUMBER() OVER(PARTITION BY cs.course_name ORDER BY cs.score DESC) as row_desc
    FROM course_scores cs
)
SELECT course_name, AVG(score) as median
FROM OrderedScores
WHERE row_asc = row_desc OR row_asc + 1 = row_desc OR row_asc = row_desc + 1
GROUP BY course_name;


1. 각 학생의 성적 평균 구하기
SELECT s.student_id, AVG(sc.score) AS avg_score
FROM students s
JOIN scores sc ON s.student_id = sc.student_id
GROUP BY s.student_id;

2. 모든 학생의 성적 합계 구하기
SELECT s.student_name, SUM(sc.score) AS total_score
FROM students s
JOIN scores sc ON s.student_id = sc.student_id
GROUP BY s.student_name;

3. 각 학생의 영어 점수 구하기
SELECT s.student_name, sc.score
FROM studetns s
	JOIN scores sc
	ON st_student_id = sc.student_id
   WHERE sc.subject = 'English';

4. 각 과목별 평균 점수 구하기
SELECT sc.subject, AVG(sc.score) AS avg_score
FROM scores sc
GROUP BY sc.subject;


5. 85점 초과 학생의 성적 정보 구하기
SELECT s.student_name, sc.subject, sc.score
FROM students s
JOIN scores sc ON s.student_id = sc.student_id
WHERE sc.score > 85;


1. JOIN
목적: 두 개 이상의 테이블을 연결하여 원하는 데이터를 가져오기 위해 사용합니다.

사용 사례: 학생과 성적 테이블이 있을 때, 학생의 이름과 해당 학생의 성적을 함께 출력하고 싶을 때.
sql
Copy code
SELECT students.name, scores.grade
FROM students
JOIN scores ON students.student_id = scores.student_id;
2. GROUP BY
목적: 특정 열(들)을 기준으로 행들을 그룹화하고, 각 그룹에 대해 집계 함수 (예: COUNT, SUM, AVG, MAX, MIN 등)를 적용하기 위해 사용합니다.

사용 사례: 성적 테이블에서 각 학생별로 평균 점수를 구하고 싶을 때.
sql
Copy code
SELECT student_id, AVG(grade)
FROM scores
GROUP BY student_id;
합쳐서 사용할 때
때로는 JOIN과 GROUP BY를 동시에 사용해야 할 때가 있습니다.

사용 사례: 학생과 성적 테이블이 있을 때, 학생의 이름별로 평균 점수를 구하고 싶을 때.
sql
Copy code
SELECT students.name, AVG(scores.grade)
FROM students
JOIN scores ON students.student_id = scores.student_id
GROUP BY students.name;
요점:

JOIN은 테이블들 간의 연관된 데이터를 결합하기 위해 사용합니다.
GROUP BY는 특정 열(들)을 기준으로 데이터를 그룹화하고 그룹별로 집계 함수를 적용하기 위해 사용합니다.
두 연산자를 함께 사용하면, 여러 테이블의 데이터를 결합하고, 그 결합된 데이터에 대해 그룹화 및 집계를 수행할 수 있습니다.
JOIN과 GROUP BY를 사용할 때 주의해야 할 점은 JOIN된 결과 테이블에 GROUP BY를 적용하게 됩니다. 따라서 어떤 열을 GROUP BY의 기준으로 설정할지, 어떤 집계 함수를 어떻게 사용할지를 잘 생각해서 쿼리를 작성해야 합니다.

1. GROUP BY 없이 집계 함수 사용:
예를 들어, 전체 학생들의 평균 점수를 알고 싶을 때는 GROUP BY 없이 집계 함수만 사용할 수 있습니다.

sql
Copy code
SELECT AVG(score) AS average_score
FROM scores;
이 쿼리는 scores 테이블의 모든 행에 대해 평균 점수를 계산합니다.

2. GROUP BY와 함께 집계 함수 사용:
반면, 각 학생별 평균 점수를 알고 싶을 때는 GROUP BY를 사용해 학생별로 그룹화한 뒤 집계 함수를 적용할 수 있습니다.

sql
Copy code
SELECT student_id, AVG(score) AS average_score
FROM scores
GROUP BY student_id;
이 쿼리는 각 학생별로 그룹화된 데이터에 대해 평균 점수를 계산합니다.

결론:

GROUP BY 없이 집계 함수를 사용하면 전체 데이터에 대한 집계 값을 얻습니다.
GROUP BY와 함께 집계 함수를 사용하면 특정 열(들)을 기준으로 그룹화된 데이터에 대한 집계 값을 얻습니다.




