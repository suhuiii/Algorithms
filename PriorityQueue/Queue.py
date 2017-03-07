class item():
	def __init__(self, data, next = None):
		self.data = data
		self.next = None

	def __str__(self):
		return str(self.data)

class Queue():
	def __init__(self):
		self.length = 0
		self.head = None
		self.next = None

	def is_empty(self):
		return self.length == 0

	def insert(self, newItem):
		i = item(newItem)
		if self.head is None:
			self.head = i
		else:
			last = self.head
			while last.next:
				last = last.next
			last.next = i
		self.length +=1
		return

	def remove(self):
		temp = self.head
		self.head = self.head.next
		self.length-=1
		return temp.data

	def printContents(self):
		last = self.head
		string = last.data
		while last.next:
			last = last.next
			string += last.data
			
		print(string)

	def peekHead(self):
		return self.head.data

class PriorityQueue(Queue):
	def __init__(self):
		super(PriorityQueue, self).__init__()
		self.next = None

	def insert(self, newItem):
		it = item(newItem)
		if self.head is None:
			self.head = it
		else:
			if it.data > self.head.data:
				it.next = self.head
				self.head = it
			else:
				last = self.head
				for i in range(self.length-1):
					if last.next.data > it.data:
						last = last.next
				it.next = last.next
				last.next = it

		self.length +=1
		return
	
	
	