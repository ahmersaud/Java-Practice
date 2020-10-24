#include "dll_specification.h"

int main()
{
	DoublyLinkedList list;
	list.addToDLLHead(10);
	list.addToDLLHead(20);
	list.addToDLLHead(30);
	list.deleteFromDLLHead();
	list.printout();
	return 0;
}