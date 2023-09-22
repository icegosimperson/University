#pragma once

#include "resource.h"

// CObject 클래스를 상속받는 CMyClass 클래스 선언
class CMyClass : public CObject 
{
    DECLARE_DYNAMIC(CMyClass) //클래스 정보를 동적으로 생성하기 위한 매크로

public:
    CMyClass(); // 생성자
    virtual ~CMyClass();  // 가상 소멸자
    void DoSomething(); // 임의의 멤버 함수

protected:
    int m_nValue; // 임의의 멤버 변수
};

IMPLEMENT_DYNAMIC(CMyClass, CObject) //클래스 정보를 동적으로 생성하기 위한 매크로

// 생성자 정의
CMyClass::CMyClass()
{
    m_nValue = 0;  // 멤버 변수 m_nValue의 초기값 설정
}

// 소멸자 정의
CMyClass::~CMyClass()
{
}

// 멤버 함수 정의
void CMyClass::DoSomething()
{
    // 임의의 작업 수행
    m_nValue += 1;
}