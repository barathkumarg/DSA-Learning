"""
List Usefule methods in python
create, append, insert, remove, pop, clear, index, count, sort, reverse, copy
"""

mylist = [1, 2, 3, 4, 5]
print(f"Initial List: {mylist}")

#append
mylist.append(6)  # [1,2,3,4,5,6]
print(f"Append '6': {mylist}")

#pop
mylist.pop()  # [1,2,3,4,5]
print(f"Pop last element: {mylist}")

#insert
mylist.insert(2, 10)  # [1,2,10,3,4,5]
print(f"Insert '10' at index 2: {mylist}")

#remove
mylist.remove(10)  # [1,2,3,4,5]
print(f"Remove '10': {mylist}")

#clear
mylist.clear()  # []
print(f"Clear list: {mylist}")

#copy
mylist = [1, 2, 3, 4, 5]
mylist_copy = mylist.copy()  # [1,2,3,4,5]
print(f"Copy list: {mylist_copy}")

#count
count_of_2 = mylist.count(2)  # 1
print(f"Count of '2' in list: {count_of_2}")

#index
index_of_3 = mylist.index(3)  # 2
print(f"Index of '3' in list: {index_of_3}")

#sort
mylist.sort()  # [1,2,3,4,5]
print(f"Sort list: {mylist}")

#reverse
mylist.reverse()  # [5,4,3,2,1]
# another method: mylist[::-1]
print(f"Reverse list: {mylist}")

#indexing and slicing
print(f"Indexing: {mylist[0]}")  # 5
print(f"Slicing: {mylist[1:4]}")  # [4,3,2] 

#membership
print(f"Is '5' in list? {'5' in mylist}")  # True
