	.globl	Main_main
Main_main:
	pushl	%ebp
	movl	%esp,%ebp
	subl	$16,%esp
	movl	$1,%eax
	movl	%eax,-4(%ebp)
	orl	%eax,%eax
	jnz	l2
	movl	$1,%eax
	movl	%eax,-8(%ebp)
	orl	%eax,%eax
	jz	l0
l2:
	movl	-4(%ebp),%eax
	orl	%eax,%eax
	jz	l3
	movl	$0,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l4
l3:
	movl	$1,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
l4:
	jmp	l1
l0:
l1:
	movl	$1,%eax
	movl	%eax,-12(%ebp)
	orl	%eax,%eax
	jnz	l7
	movl	-12(%ebp),%eax
	movl	%eax,-16(%ebp)
	orl	%eax,%eax
	jz	l5
l7:
	movl	-12(%ebp),%eax
	orl	%eax,%eax
	jz	l8
	movl	$0,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l9
l8:
	movl	$1,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
l9:
	jmp	l6
l5:
l6:
	movl	%ebp,%esp
	popl	%ebp
	ret
