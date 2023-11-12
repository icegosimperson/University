-- donor_list
 
-- 관리자가 모든 후원자들의 정보를 조회하는 화면입니다.
-- 화면 구성 후원자 id / 후원자 이름 / 후원자 폰번호 / 회원가입시 선택한 선호 카테고리

USE `Donation_Manage`;

SELECT 
    d.id AS 'Donor ID', 
    d.name AS 'Name', 
    d.phone AS 'Phone',
    c.name AS 'Category'
FROM 
    `Donation_Manage`.`donor` d
JOIN 
    `Donation_Manage`.`category` c ON d.category_id = c.id
ORDER BY 
    d.id;



-- total_program_list
 
-- 관리자가 모든 프로그램의 리스트를 보는 화면 입니다.

-- 화면 구성 
-- 프로그램 이름 / 카테고리 / 회사명 / 시작 날짜 / 마감날짜 / 총 후원 금액

USE `Donation_Manage`;

SELECT 
    p.program_name AS 'Program Name', 
    cat.name AS 'Category',
    phc.company_name AS 'Host Company', 
    p.start_date AS 'Start Date', 
    p.end_date AS 'End Date', 
    IFNULL(SUM(d.money), 0) AS 'Total Donation Amount'
FROM 
    `Donation_Manage`.`program` p
JOIN 
    `Donation_Manage`.`category` cat ON p.category_id = cat.id
JOIN 
    `Donation_Manage`.`program_host_company` phc ON p.program_host_company_id = phc.id
LEFT JOIN 
    `Donation_Manage`.`donation` d ON p.program_name = d.program_program_name
GROUP BY 
    p.program_name, cat.name, phc.company_name, p.start_date, p.end_date
ORDER BY 
    p.program_name;

category
 
USE `Donation_Manage`;

SELECT 
	c.id 'id',
    c.name 'name'
FROM `Donation_Manage`.`category` c;


-- new_category
-- 관리자가 새로운 카테고리를 추가하는 페이지 입니다.

USE `Donation_Manage`;

-- 제약 조건 : 카테고리 id 중복x
ALTER TABLE `category`
ADD UNIQUE (`id`);

-- 제약 조건2 : 카테고리 name 중복x
ALTER TABLE `category`
ADD UNIQUE (`name`);

-- 관리자가 카테고리 id, 이름을 입력하여 새로운 카테고리를 생성함 
INSERT INTO `category` (`id`, `name`)
VALUES ('입력한 ID', '입력한 카테고리 이름')
ON DUPLICATE KEY UPDATE `id` = `id`;

