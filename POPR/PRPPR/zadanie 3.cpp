#include <iostream>

using namespace std;
int liczba;

int main()
{
    cout<<"Wpisz liczbe: ";
    cin>>liczba;
    if(liczba%2==1)
    {
        cout<<"Liczba jest nieparzysta"<<endl;
    }
    else
    {
        cout<<"Liczba jest parzysta"<<endl;
    }
}
