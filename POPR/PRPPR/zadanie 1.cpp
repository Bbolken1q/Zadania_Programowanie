#include <iostream>

using namespace std;

long double liczba;

int main()
{
    cout<<"Wpisz liczbe: "<< endl;
    cin>>liczba;
    if(liczba<0)
    {
        liczba = liczba*-1;
    }
    cout<<"Liczba bezwzgledna z tej liczby to: "<<liczba<<endl;
    return 0;
}
