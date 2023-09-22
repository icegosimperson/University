// Lab1_22012464_이혜원.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include "pch.h"
#include "framework.h"
#include "Lab1_22012464_이혜원.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


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
            _tsetlocale(LC_ALL, _T("")); //콘솔에서 한글(유니코드)을 출력 가능하게

            CRect rect1(0, 0, 200, 100);
            CRect rect2;
            rect2.SetRect(0, 0, 200, 100);

            if (rect1 == rect2)
                _tprintf(_T("두 직사각형의 좌표가 같습니다.\n"));
            else
                _tprintf(_T("두 직사각형의 좌표가 다릅니다.\n"));
            RECT rect = { 100, 100, 300, 200 };
            CRect rect3(rect);
            _tprintf(_T("%d, %d\n"), rect3.Width(), rect3.Height());

            CPoint pt(200, 150);
            if (rect3.PtInRect(pt))
                _tprintf(_T("점이 직사각형 내부에 있습니다.\n"));
            else
                _tprintf(_T("점이 직사각형 외부에 있습니다.\n"));
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
