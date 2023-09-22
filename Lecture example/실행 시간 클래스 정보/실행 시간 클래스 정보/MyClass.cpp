#include <afxwin.h>
#include <iostream>
#include <string>

#include "pch.h"
#include "framework.h"
#include  "MyClass.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif

//�ش� �����Ͱ� CMyClass Ÿ���� ��ü�� ����Ű������ Ȯ���ϴ� �Լ�
BOOL IsMyClass(CObject* pObj)
{
    // pObj�� ����Ű�� ��ü�� CMyClass Ÿ������ Ȯ��
    if (pObj->IsKindOf(RUNTIME_CLASS(CMyClass)))
    {
        _tprintf(_T("pObj is of type CMyClass"));
        CMyClass* pMyClass = dynamic_cast<CMyClass*>(pObj); // CMyClass Ÿ������ �ٿ�ĳ����
        pMyClass->DoSomething(); // CMyClass�� ��� �Լ� ȣ��
        return TRUE;
    }
    else
    {
        _tprintf(_T("pObj is not of type CMyClass\n"));
        return FALSE;
    }
}

// ������ ���ø����̼� ��ü�Դϴ�.
CWinApp theApp;

using namespace std;

int main()
{
    int nRetCode = 0;

    HMODULE hModule = ::GetModuleHandle(nullptr);

    if (hModule != nullptr)
    {
        // MFC�� �ʱ�ȭ�մϴ�. �ʱ�ȭ���� ���� ��� ������ �μ��մϴ�.
        if (!AfxWinInit(hModule, nullptr, ::GetCommandLine(), 0))
        {
            // TODO: ���⿡ ���ø����̼� ������ �ڵ��մϴ�.
            wprintf(L"�ɰ��� ����: MFC �ʱ�ȭ ����\n");
            nRetCode = 1;
        }
        else
        {
            // TODO: ���⿡ ���ø����̼� ������ �ڵ��մϴ�.
            CMyClass myClass; // CMyClass Ÿ���� ��ü�� myClass�� ����
            IsMyClass(&myClass); // CMyClass Ÿ�� ��ü�� ���ڷ� �����Ͽ� �Լ� ����
        }
    }
    else
    {
        // TODO: ���� �ڵ带 �ʿ信 ���� �����մϴ�.
        wprintf(L"�ɰ��� ����: GetModuleHandle ����\n");
        nRetCode = 1;
    }

    return nRetCode;
}