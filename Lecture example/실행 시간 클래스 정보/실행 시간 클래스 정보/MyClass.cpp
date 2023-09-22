#include <afxwin.h>
#include <iostream>
#include <string>

#include "pch.h"
#include "framework.h"
#include  "MyClass.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif

//해당 포인터가 CMyClass 타입의 객체를 가리키는지를 확인하는 함수
BOOL IsMyClass(CObject* pObj)
{
    // pObj가 가리키는 객체가 CMyClass 타입인지 확인
    if (pObj->IsKindOf(RUNTIME_CLASS(CMyClass)))
    {
        _tprintf(_T("pObj is of type CMyClass"));
        CMyClass* pMyClass = dynamic_cast<CMyClass*>(pObj); // CMyClass 타입으로 다운캐스팅
        pMyClass->DoSomething(); // CMyClass의 멤버 함수 호출
        return TRUE;
    }
    else
    {
        _tprintf(_T("pObj is not of type CMyClass\n"));
        return FALSE;
    }
}

// 유일한 애플리케이션 개체입니다.
CWinApp theApp;

using namespace std;

int main()
{
    int nRetCode = 0;

    HMODULE hModule = ::GetModuleHandle(nullptr);

    if (hModule != nullptr)
    {
        // MFC를 초기화합니다. 초기화하지 못한 경우 오류를 인쇄합니다.
        if (!AfxWinInit(hModule, nullptr, ::GetCommandLine(), 0))
        {
            // TODO: 여기에 애플리케이션 동작을 코딩합니다.
            wprintf(L"심각한 오류: MFC 초기화 실패\n");
            nRetCode = 1;
        }
        else
        {
            // TODO: 여기에 애플리케이션 동작을 코딩합니다.
            CMyClass myClass; // CMyClass 타입의 객체인 myClass를 생성
            IsMyClass(&myClass); // CMyClass 타입 객체를 인자로 전달하여 함수 실행
        }
    }
    else
    {
        // TODO: 오류 코드를 필요에 따라 수정합니다.
        wprintf(L"심각한 오류: GetModuleHandle 실패\n");
        nRetCode = 1;
    }

    return nRetCode;
}