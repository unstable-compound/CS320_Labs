	.globl	Main_main
Main_main:
	pushl	%ebp
	movl	%esp,%ebp
	subl	$12,%esp
	movl	$0,%eax
	movl	%eax,-8(%ebp)
	movl	%eax,-4(%ebp)
	movl	$10,%eax
	movl	-4(%ebp),%ebx
	cmpl	%eax,%ebx
	jnl	l0
	movl	$2,%eax
	movl	-4(%ebp),%ebx
	addl	%ebx,%eax
	movl	%eax,-12(%ebp)
	movl	-12(%ebp),%eax
	movl	-4(%ebp),%ebx
	addl	%ebx,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l1
l0:
	movl	$2,%eax
	movl	-8(%ebp),%ebx
	cmpl	%eax,%ebx
	jl	l2
	movl	$0,%eax
	jmp	l3
l2:
	movl	$1,%eax
l3:
	movl	%eax,-12(%ebp)
	movl	-12(%ebp),%eax
	orl	%eax,%eax
	jz	l4
	movl	-8(%ebp),%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l5
l4:
l5:
l1:
	movl	$3,%eax
	movl	-4(%ebp),%ebx
	addl	%ebx,%eax
	movl	%eax,-12(%ebp)
	movl	-12(%ebp),%eax
	pushl	%eax
	call	print
	movl	%ebp,%esp
	popl	%ebp
	ret
