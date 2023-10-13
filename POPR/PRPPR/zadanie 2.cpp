#include <iostream>

using namespace std;

long double liczba;

int main()
{
    cout<<"Wpisz liczbe: ";
    cin>>liczba;
    if(liczba>0)
    {
        cout<<"Liczba jest wieksza od 0"<<endl;
    }
    else if(liczba<0)
    {
        cout<<"Liczba jest mniejsza od 0"<<endl;
    }
    else
    {
        cout<<"Liczba jest rowna 0"<<endl;
    }
    return 0;
}
